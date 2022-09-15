package io.devpass.creditcard.data.entities

import java.time.LocalDateTime
import org.hibernate.annotations.CreationTimestamp
import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class CreditCardEntity(
    @Id val id: String,
    val owner: String,
    val number: String,
    val securityCode: String,
    val printedName: String,
    val credit_limit: Double,
    val availableCreditLimit: Double,
    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @CreationTimestamp
    val updatedAt: LocalDateTime = LocalDateTime.now(),
) {

    // fun toCreditCard() : CreditCard {} // This function will return the domain object

}
