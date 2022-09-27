package io.devpass.creditcard.domainaccess

import io.devpass.creditcard.domain.objects.CreditCard
import io.devpass.creditcard.domain.objects.CreditCardRequest

interface ICreditCardServiceAdapter {
    fun findCreditCardById(creditCardId: String): CreditCard?

    fun requestCreditCard(creditCardRequest: CreditCardRequest) : CreditCard
}