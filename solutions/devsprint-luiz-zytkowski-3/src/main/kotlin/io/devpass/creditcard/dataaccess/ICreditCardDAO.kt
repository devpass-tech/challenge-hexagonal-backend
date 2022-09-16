package io.devpass.creditcard.dataaccess

import io.devpass.creditcard.domain.objects.CreditCard

interface ICreditCardDAO {
    fun getCrecitCardById(id: Int) : CreditCard
}