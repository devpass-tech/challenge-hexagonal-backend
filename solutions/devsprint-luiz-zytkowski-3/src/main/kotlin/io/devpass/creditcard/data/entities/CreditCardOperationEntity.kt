package io.devpass.creditcard.data.entities

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class CreditCardOperationEntity(
    @Id
    var id: String,
    var credit_card: String,
    var type: String,
    var value: Double,
    var description: String,
    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now(),
)