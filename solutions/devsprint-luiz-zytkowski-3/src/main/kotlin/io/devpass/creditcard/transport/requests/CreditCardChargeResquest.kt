package io.devpass.creditcard.transport.requests

import io.devpass.creditcard.domain.objects.CreditCardCharge

data class CreditCardChargeResquest(
    val id: String,
    val creditCardId: String,
    val purchaseValue: Double,
    val installmentNumber: Int,
    val installmentValue: Double,
    val description: String,
) {
    fun toCreditCardCharge(): CreditCardCharge {
        return CreditCardCharge(
            id = this.id,
            creditCardId = this.creditCardId,
            purchaseValue = this.purchaseValue,
            installmentNumber = this.installmentNumber,
            installmentValue = this.installmentValue,
            description = this.description,
        )
    }
}