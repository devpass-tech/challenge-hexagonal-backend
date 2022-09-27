package io.devpass.creditcard.domain

import io.devpass.creditcard.dataaccess.ICreditCardDAO
import io.devpass.creditcard.dataaccess.ICreditCardOperationDAO
import io.devpass.creditcard.domain.objects.CreditCardCharge
import io.devpass.creditcard.domain.objects.CreditCardOperation
import io.devpass.creditcard.domainaccess.ICreditCardOperationServiceAdapter
import javax.persistence.EntityNotFoundException
import java.time.LocalDateTime

abstract class CreditCardOperationService(
        private val creditCardOperationDAO: ICreditCardOperationDAO,
        private val creditCardDAO: ICreditCardDAO,
) : ICreditCardOperationServiceAdapter {
    override fun getById(creditCardOperationId: String): CreditCardOperation? {
        return creditCardOperationDAO.getById(creditCardOperationId)
    }

    override fun rollbackOperation(creditCardCharge: CreditCardCharge, creditCardOperation: CreditCardOperation): CreditCardOperation {
        val creditCard = creditCardDAO.getCreditCardById(creditCardCharge.creditCard)
                ?: throw EntityNotFoundException("Cartão de id: ${creditCardCharge.creditCard} não encontrado")

        val getOperation = creditCardOperationDAO.getById(creditCardOperation.id)
                ?: throw EntityNotFoundException("Operação não encontrada")

        creditCard.availableCreditLimit += creditCardCharge.purchaseValue
        creditCardDAO.updateAvailableCreditLimit(creditCard)

        return CreditCardOperation(
                id = "", //will be auto-generated
                creditCard = getOperation.creditCard,
                type = "Estorno",
                value = (creditCardCharge.purchaseValue / creditCardCharge.installmentNumber) * -1,
                description = "${creditCardCharge.description} ${creditCardCharge.installmentNumber}",
                month = LocalDateTime.now().monthValue,
                year = LocalDateTime.now().year
        )
    }
}