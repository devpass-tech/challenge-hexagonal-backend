package io.devpass.creditcard.data.entities

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
)