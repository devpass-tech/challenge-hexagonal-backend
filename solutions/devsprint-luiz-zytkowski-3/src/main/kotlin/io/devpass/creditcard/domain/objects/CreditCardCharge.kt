package io.devpass.creditcard.domain.objects

data class CreditCardCharge(
    val id: String,
    val creditCardId: String,
    val purchaseValue: Double,
    val installmentNumber: Int,
    val installmentValue: Double,
    val description: String,
)