package io.devpass.creditcard.dataaccess

import io.devpass.creditcard.domain.objects.CreditCardOperation

interface ICreditCardOperationDAO {
    fun getById(id: String): CreditCardOperation?
    fun operationReport(id: String, month: Int, year: Int) : List<CreditCardOperation>
    fun save(creditCardOperation: CreditCardOperation): CreditCardOperation
}