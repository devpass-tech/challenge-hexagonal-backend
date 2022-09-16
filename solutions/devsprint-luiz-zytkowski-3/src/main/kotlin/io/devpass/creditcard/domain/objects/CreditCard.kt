package io.devpass.creditcard.domain.objects

data class CreditCard(
    val id: String,
    var owner: String,
    var number: String,
    var securityCode: String,
    var printedName: String,
    var credit_limit: Double,
    var availableCreditLimit: Double,
)
