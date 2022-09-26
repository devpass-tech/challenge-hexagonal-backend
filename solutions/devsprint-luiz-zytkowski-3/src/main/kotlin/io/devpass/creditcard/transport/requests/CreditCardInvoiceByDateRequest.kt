package io.devpass.creditcard.transport.requests

import io.devpass.creditcard.domain.objects.CreditCardInvoiceByDate

data class CreditCardInvoiceByDateRequest(
    val creditCard: String,
    val month: Int,
    val year: Int
) {
    fun toCreditCardInvoiceByDate(): CreditCardInvoiceByDate {
        return CreditCardInvoiceByDate(
            this.creditCard,
            this.month,
            this.year
        )
    }
}