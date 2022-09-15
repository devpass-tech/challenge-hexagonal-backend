package io.devpass.creditcard.data.entities

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.Id

data class CreditCardInvoiceEntity(
    @Id
    val id: String,
    val creditCard: String,
    val month: Int,
    val year: Int,
    val value: Double,
    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @CreationTimestamp
    val paitAt: LocalDateTime? = LocalDateTime.now()
)