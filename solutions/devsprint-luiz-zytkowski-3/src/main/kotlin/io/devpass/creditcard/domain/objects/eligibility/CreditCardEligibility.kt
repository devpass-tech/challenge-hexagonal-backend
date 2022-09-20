package io.devpass.creditcard.domain.objects.eligibility

class CreditCardEligibility(
    val shouldHaveCreditCard: Boolean,
    val proposedLimit: Double?
)