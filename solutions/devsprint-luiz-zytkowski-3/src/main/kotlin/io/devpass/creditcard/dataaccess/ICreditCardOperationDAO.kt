package io.devpass.creditcard.dataaccess

import io.devpass.creditcard.domain.objects.CreditCardOperation

interface ICreditCardOperationDAO {

    fun getById(id: String): CreditCardOperation?
    fun save(creditCardOperation: CreditCardOperation): CreditCardOperation
}