package io.devpass.creditcard.transport.requests

import io.devpass.creditcard.domain.objects.CreditCardCharge

data class CreditCardChargeRequest(
    val creditCard: String,
    val purchaseValue: Double,
    val installmentNumber: Int,
    val month: Int,
    val year: Int,
    val description: String,
) {
    fun toCreditCardCharge(): CreditCardCharge {
        return CreditCardCharge(
            creditCard = this.creditCard,
            purchaseValue = this.purchaseValue,
            installmentNumber = this.installmentNumber,
            month = this.month,
            year = this.year,
            description = this.description,
        )
    }
}