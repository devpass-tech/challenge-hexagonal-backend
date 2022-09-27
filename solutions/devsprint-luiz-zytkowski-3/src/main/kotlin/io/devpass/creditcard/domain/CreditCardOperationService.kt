package io.devpass.creditcard.domain

import io.devpass.creditcard.dataaccess.ICreditCardDAO
import io.devpass.creditcard.dataaccess.ICreditCardOperationDAO
import io.devpass.creditcard.domain.exceptions.BusinessRuleException
import io.devpass.creditcard.domain.exceptions.EntityNotFoundException
import io.devpass.creditcard.domain.objects.CreditCardCharge
import io.devpass.creditcard.domain.objects.CreditCardOperation
import io.devpass.creditcard.domainaccess.ICreditCardOperationServiceAdapter
import java.time.LocalDate

class CreditCardOperationService(
    private val creditCardOperationDAO: ICreditCardOperationDAO,
    private val creditCardDAO: ICreditCardDAO,
) : ICreditCardOperationServiceAdapter {

    override fun getById(creditCardOperationId: String): CreditCardOperation? {
        return creditCardOperationDAO.getById(creditCardOperationId)
    }

    override fun operationReport(
        creditCardId: String,
        operationMonth: Int,
        operationYear: Int
    ): List<CreditCardOperation?> {
        creditCardDAO.getCreditCardById(creditCardId)
            ?: throw EntityNotFoundException("Cartão de id: $creditCardId não encontrado")

        if (operationMonth !in 1..12) {
            throw BusinessRuleException("Mês inserido inválido")
        }

        if (operationYear < 1950) {
            throw BusinessRuleException("Ano inserido inválido")
        }

        return creditCardOperationDAO.operationReport(creditCardId, operationMonth, operationYear)
    }
    
    override fun createCreditCardOperation(creditCardCharge: CreditCardCharge): List<CreditCardOperation> {
        val creditCardOperationList: MutableList<CreditCardOperation> = mutableListOf()
        var chargingPeriod = LocalDate.now().withDayOfMonth(1)

        for (i in 1 until creditCardCharge.installmentNumber) {
            creditCardOperationList.add(
                CreditCardOperation(
                    id = "", //will be auto-generated
                    creditCard = creditCardCharge.creditCard,
                    type = "Cobrança",
                    value = creditCardCharge.purchaseValue / creditCardCharge.installmentNumber,
                    description = "${creditCardCharge.description} $i/${creditCardCharge.installmentNumber}",
                    month = chargingPeriod.monthValue,
                    year = chargingPeriod.year
                )
            )
            chargingPeriod = chargingPeriod.plusMonths(1)
        }
        return creditCardOperationList.map { creditCardOperationDAO.save(it) }
    }

    override fun chargeCreditCard(creditCardCharge: CreditCardCharge): List<CreditCardOperation> {
        val creditCard = creditCardDAO.getCreditCardById(creditCardCharge.creditCard)
            ?: throw EntityNotFoundException("Cartão de id: ${creditCardCharge.creditCard} não encontrado")

        if (creditCardCharge.purchaseValue > creditCard.availableCreditLimit)
            throw BusinessRuleException("Não há limite para a compra de valor R$${creditCardCharge.purchaseValue}. Limite disponível: ${creditCard.availableCreditLimit}")

        if (creditCardCharge.installmentNumber < 1 || creditCardCharge.installmentNumber > 12)
            throw BusinessRuleException("O número de parcelas desta transação (${creditCardCharge.installmentNumber}) não está entre o permitido: 1 a 12")

        if (creditCardCharge.installmentNumber > 1 && creditCardCharge.purchaseValue < 6)
            throw BusinessRuleException("O valor da compra R$${creditCardCharge.purchaseValue} é menor do que o mínimo permitido: R$6,00")

        creditCard.availableCreditLimit -= creditCardCharge.purchaseValue
        creditCardDAO.updateAvailableCreditLimit(creditCard)

        return createCreditCardOperation(creditCardCharge)
    }
}