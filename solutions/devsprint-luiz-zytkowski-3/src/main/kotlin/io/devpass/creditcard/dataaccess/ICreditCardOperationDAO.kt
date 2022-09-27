package io.devpass.creditcard.dataaccess

import io.devpass.creditcard.domain.objects.CreditCardOperation
import io.devpass.creditcard.domainaccess.ICreditCardOperationServiceAdapter

interface ICreditCardOperationDAO {
    fun getById(id: String): CreditCardOperation?
    fun rollbackOperation(creditCardOperation: CreditCardOperation): CreditCardOperation
    fun operationReport(id: String, month: Int, year: Int) : List<CreditCardOperation>
    fun save(creditCardOperation: CreditCardOperation): CreditCardOperation
}
