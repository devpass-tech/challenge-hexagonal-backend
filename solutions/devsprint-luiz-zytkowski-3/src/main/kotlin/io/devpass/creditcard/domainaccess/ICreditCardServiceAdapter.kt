package io.devpass.creditcard.domainaccess

import io.devpass.creditcard.domain.objects.CreditCard

interface ICreditCardServiceAdapter {
    fun findCreditCardById(creditCardId: String): CreditCard?
}