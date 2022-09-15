package io.devpass.creditcard.data.entities

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class CreditCardOperationEntity(
    @Id
    val id: String,
    val credit_card: String,
    val type: String,
    val value: Double,
    val description: String,
    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now(),
)