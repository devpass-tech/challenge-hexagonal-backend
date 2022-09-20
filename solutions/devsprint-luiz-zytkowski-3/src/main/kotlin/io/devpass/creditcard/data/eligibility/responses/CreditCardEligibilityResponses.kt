package io.devpass.creditcard.data.eligibility.responses

import io.devpass.creditcard.domain.objects.eligibility.CreditCardEligibility


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