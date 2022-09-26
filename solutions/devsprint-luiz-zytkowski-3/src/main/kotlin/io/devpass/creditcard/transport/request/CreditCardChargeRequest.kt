package io.devpass.creditcard.transport.requests

import io.devpass.creditcard.domain.objects.CreditCardCharge

data class CreditCardChargeRequest(
        val creditCard: String,
        val purchaseValue: Double,
        val installmentNumber: Int,
        val description: String,
) {
    fun toCreditCardCharge(): CreditCardCharge {
        return CreditCardCharge(
                creditCard = this.creditCard,
                purchaseValue = this.purchaseValue,
                installmentNumber = this.installmentNumber,
                description = this.description,
        )
    }
}