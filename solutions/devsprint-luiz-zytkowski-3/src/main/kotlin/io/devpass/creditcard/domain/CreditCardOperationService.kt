package io.devpass.creditcard.domain

import io.devpass.creditcard.dataaccess.ICreditCardOperationDAO
import io.devpass.creditcard.domain.objects.CreditCardOperation
import io.devpass.creditcard.domainaccess.ICreditCardOperationServiceAdapter

class CreditCardOperationService(
    private val creditCardOperationDAO: ICreditCardOperationDAO,
) : ICreditCardOperationServiceAdapter {
    override fun getById(creditCardOperationId: String): CreditCardOperation? {
        return creditCardOperationDAO.getById(creditCardOperationId)
    }
}