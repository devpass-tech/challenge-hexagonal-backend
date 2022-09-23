package io.devpass.creditcard.domain

import io.devpass.creditcard.dataaccess.ICreditCardDAO
import io.devpass.creditcard.dataaccess.ICreditCardOperationDAO
import io.devpass.creditcard.domain.exceptions.OwnedException
import io.devpass.creditcard.domain.objects.CreditCard
import io.devpass.creditcard.domain.objects.CreditCardOperation
import io.devpass.creditcard.domainaccess.ICreditCardOperationServiceAdapter
import java.time.LocalDate
import javax.persistence.EntityNotFoundException

class CreditCardOperationService(
    private val creditCardOperationDAO: ICreditCardOperationDAO,
    private val creditCardDAO: ICreditCardDAO
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

        if (operationMonth in 1..12) {
            throw OwnedException("Mês inserido inválido")
        }

        if (operationYear < 1950) {
            throw OwnedException("Ano inserido inválido")
        }

        return operationReport(creditCardId, operationMonth, operationYear)
    }
}