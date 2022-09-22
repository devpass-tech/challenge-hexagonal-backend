package io.devpass.creditcard.domainaccess

import io.devpass.creditcard.domain.objects.CreditCard
import io.devpass.creditcard.domain.objects.CreditCardCharge

interface ICreditCardServiceAdapter {
    fun findCreditCardById(creditCardId: String): CreditCard?
    fun chargeCreditCard(creditCardCharge: CreditCardCharge)
}