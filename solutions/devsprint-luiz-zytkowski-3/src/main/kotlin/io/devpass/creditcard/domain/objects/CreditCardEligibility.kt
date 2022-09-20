package io.devpass.creditcard.domain.objects

class CreditCardEligibility(
    val shouldHaveCreditCard: Boolean,
    val proposedLimit: Double?
)