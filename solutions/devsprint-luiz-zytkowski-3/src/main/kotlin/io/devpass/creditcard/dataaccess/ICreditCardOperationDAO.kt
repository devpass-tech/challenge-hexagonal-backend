package io.devpass.creditcard.dataaccess

import io.devpass.creditcard.data.CreditCardOperationDAO

interface ICreditCardOperationDAO {

    fun getById(id: String): CreditCardOperationDAO
}