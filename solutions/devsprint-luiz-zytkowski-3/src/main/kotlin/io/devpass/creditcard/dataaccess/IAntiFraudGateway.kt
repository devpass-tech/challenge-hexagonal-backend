package io.devpass.creditcard.dataaccess

import io.devpass.creditcard.domain.objects.eligibility.CreditCardEligibility

interface IAntiFraudGateway {
    fun creditCardEligibility(document: String): CreditCardEligibility
}
