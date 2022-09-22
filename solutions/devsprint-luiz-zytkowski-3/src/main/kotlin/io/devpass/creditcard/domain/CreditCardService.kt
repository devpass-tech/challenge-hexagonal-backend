package io.devpass.creditcard.domain

import io.devpass.creditcard.dataaccess.IAccountManagementGateway
import io.devpass.creditcard.dataaccess.ICreditCardDAO
import io.devpass.creditcard.domain.exceptions.OwnedException
import io.devpass.creditcard.domain.objects.CreditCard
import io.devpass.creditcard.domain.objects.CreditCardCharge
import io.devpass.creditcard.domainaccess.ICreditCardOperationServiceAdapter
import io.devpass.creditcard.domainaccess.ICreditCardServiceAdapter

class CreditCardService(
    private val creditCardDAO: ICreditCardDAO,
    private val accountManagementGateway: IAccountManagementGateway,
    private val creditCardOperationService: ICreditCardOperationServiceAdapter,
) : ICreditCardServiceAdapter {

    override fun findCreditCardById(creditCardId: String): CreditCard? {
        return creditCardDAO.getCreditCardById(creditCardId)
    }

    override fun chargeCreditCard(creditCardCharge: CreditCardCharge) {
        val creditCard = creditCardDAO.getCreditCardById(creditCardCharge.creditCardId)
            ?: throw OwnedException("Cartão de id: ${creditCardCharge.creditCardId} não encontrado")

        //Não sei como verificar as condições e fazer uma exceção usando when
        if (creditCardCharge.purchaseValue <= creditCard.availableCreditLimit) {
            if (creditCardCharge.installmentNumber in 1..12) {
                if (creditCardCharge.installmentValue >= 6) {
                    creditCardOperationService.createCreditCardOperation(creditCardCharge)
                } else throw OwnedException("O valor das parcelas R$${creditCardCharge.installmentValue} é menor do que o mínimo permitido: R$6,00")
            } else throw OwnedException("O número de parcelas desta transação (${creditCardCharge.installmentNumber}) não está entre o permitido: 1 a 12")
        } else throw OwnedException("Não há limite para a compra de valor R$${creditCardCharge.purchaseValue}. Limite disponível: ${creditCard.availableCreditLimit}")

    }

}