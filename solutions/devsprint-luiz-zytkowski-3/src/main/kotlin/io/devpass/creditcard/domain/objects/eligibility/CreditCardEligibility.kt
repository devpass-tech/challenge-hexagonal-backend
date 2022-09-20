package io.devpass.creditcard.domain.objects.eligibility

data class CreditCardEligibility(
    val shouldHaveCreditCard: Boolean,
    val proposedLimit: Double?
)