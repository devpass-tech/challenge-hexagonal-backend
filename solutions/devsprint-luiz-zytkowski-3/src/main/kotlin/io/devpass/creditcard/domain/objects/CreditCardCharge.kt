package io.devpass.creditcard.domain.objects

data class CreditCardCharge(
    val creditCard: String,
    val purchaseValue: Double,
    val installmentNumber: Int,
    val month: Int,
    val year: Int,
    val description: String,
)