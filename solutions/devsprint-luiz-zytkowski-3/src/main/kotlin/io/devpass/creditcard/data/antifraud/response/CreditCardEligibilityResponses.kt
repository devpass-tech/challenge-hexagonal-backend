package io.devpass.creditcard.data.antifraud.response

import io.devpass.creditcard.domain.objects.antifraud.CreditCardEligibility

data class CreditCardEligibilityResponses(
    val shouldHaveCreditCard: Boolean,
    val proposedLimit: Double?
) {

    fun toCreditCardEligibility(): CreditCardEligibility {
        return CreditCardEligibility(
            shouldHaveCreditCard = this.shouldHaveCreditCard,
            proposedLimit = this.proposedLimit
        )
    }
}