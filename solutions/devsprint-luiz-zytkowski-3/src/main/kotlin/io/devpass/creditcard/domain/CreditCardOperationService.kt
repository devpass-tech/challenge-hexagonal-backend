package io.devpass.creditcard.domain

import io.devpass.creditcard.dataaccess.ICreditCardDAO
import io.devpass.creditcard.dataaccess.ICreditCardOperationDAO
import io.devpass.creditcard.domain.exceptions.BusinessRuleException
import io.devpass.creditcard.domain.exceptions.EntityNotFoundException
import io.devpass.creditcard.domain.objects.CreditCardCharge
import io.devpass.creditcard.domain.objects.CreditCardOperation
import io.devpass.creditcard.domainaccess.ICreditCardOperationServiceAdapter

class CreditCardOperationService(
    private val creditCardOperationDAO: ICreditCardOperationDAO,
    private val creditCardDAO: ICreditCardDAO,
) : ICreditCardOperationServiceAdapter {

    override fun getById(creditCardOperationId: String): CreditCardOperation? {
        return creditCardOperationDAO.getById(creditCardOperationId)
    }

    //TODO: essa função tá sem retorno, porque ela pode retornar uma lista ou só um objeto
    override fun createCreditCardOperation(creditCardCharge: CreditCardCharge) {
        if (creditCardCharge.installmentNumber > 1) {
            createSomeCreditCardOperations(creditCardCharge).forEach {
                creditCardOperationDAO.save(it)
            }
        } else creditCardOperationDAO.save(
            CreditCardOperation(
                creditCard = creditCardCharge.creditCard,
                type = "Cobrança", //TODO: Aqui poderia criar um ENUM?
                value = creditCardCharge.purchaseValue,
                description = creditCardCharge.description,
                month = creditCardCharge.month,
                year = creditCardCharge.year
            )
        )
    }

    private fun createSomeCreditCardOperations(creditCardCharge: CreditCardCharge): List<CreditCardOperation> {
        val creditCardOperationList: MutableList<CreditCardOperation> = mutableListOf()
        var iterator = 0
        var month = creditCardCharge.month
        var year = creditCardCharge.year

        while (iterator < creditCardCharge.installmentNumber) {
            month += iterator
            if (month + iterator > 12) {
                month -= 12
                year += 1
            }

            creditCardOperationList.add(
                CreditCardOperation(
                    creditCard = creditCardCharge.creditCard,
                    type = "Cobrança",
                    value = creditCardCharge.purchaseValue / creditCardCharge.installmentNumber,
                    description = creditCardCharge.description,
                    month = month,
                    year = year
                )
            )

            iterator++
        }

        return creditCardOperationList
    }

    override fun chargeCreditCard(creditCardCharge: CreditCardCharge) {
        val creditCard = creditCardDAO.getCreditCardById(creditCardCharge.creditCard)
            ?: throw EntityNotFoundException("Cartão de id: ${creditCardCharge.creditCard} não encontrado")

        if (creditCardCharge.purchaseValue > creditCard.availableCreditLimit)
            throw BusinessRuleException("Não há limite para a compra de valor R$${creditCardCharge.purchaseValue}. Limite disponível: ${creditCard.availableCreditLimit}")

        if (creditCardCharge.installmentNumber < 1 || creditCardCharge.installmentNumber > 12)
            throw BusinessRuleException("O número de parcelas desta transação (${creditCardCharge.installmentNumber}) não está entre o permitido: 1 a 12")

        if (creditCardCharge.installmentNumber > 1 && creditCardCharge.purchaseValue < 6)
            throw BusinessRuleException("O valor da compra R$${creditCardCharge.purchaseValue} é menor do que o mínimo permitido: R$6,00")

        creditCard.availableCreditLimit -= creditCardCharge.purchaseValue
        creditCardDAO.save(creditCard)

        createCreditCardOperation(creditCardCharge)
    }
}