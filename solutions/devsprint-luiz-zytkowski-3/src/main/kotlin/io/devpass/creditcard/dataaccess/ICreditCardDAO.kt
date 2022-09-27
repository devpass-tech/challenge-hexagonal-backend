package io.devpass.creditcard.dataaccess

import io.devpass.creditcard.domain.objects.CreditCard

interface ICreditCardDAO {
    fun updateAvailableCreditLimit(creditCard: CreditCard)
    fun checksExistingCreditCardByCPF(CPF: String) : CreditCard?
    fun createCreditCard(creditCard: CreditCard): CreditCard
    fun getCreditCardById(id: String): CreditCard?
}