package io.devpass.creditcard.data.entities

import io.devpass.creditcard.domain.objects.CreditCardInvoice
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.Id

data class CreditCardInvoiceEntity(
    @Id
    var id: String,
    var creditCard: String,
    var month: Int,
    var year: Int,
    var value: Double,
    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var paidAt: LocalDateTime? = LocalDateTime.now()
) {
    fun toCreditCardInvoice(): CreditCardInvoice {
        return CreditCardInvoice(
            id = this.id,
            creditCard = this.creditCard,
            month = this.month,
            year = this.year,
            value = this.value,
            createdAt = this.createdAt,
            paidAt = this.paidAt
        )
    }
}