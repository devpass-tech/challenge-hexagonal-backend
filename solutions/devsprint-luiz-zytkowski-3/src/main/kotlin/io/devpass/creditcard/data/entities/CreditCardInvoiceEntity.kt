package io.devpass.creditcard.data.entities

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

data class CreditCardInvoiceEntity(
    val id: String,
    val owner: String,
    val number: String,
    val security_code: String,
    val printed_name: String,
    val credit_limit: Double,
    val available_credit_limit: Double,
    @CreationTimestamp
    val created_at: LocalDateTime = LocalDateTime.now(),
    @CreationTimestamp
    val updated_at: LocalDateTime = LocalDateTime.now()
)