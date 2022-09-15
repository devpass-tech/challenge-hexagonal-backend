package io.devpass.creditcard.data.entities

import java.time.LocalDateTime
import org.hibernate.annotations.CreationTimestamp
import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class CreditCardEntity(
    @Id var id: String,
    var owner: String,
    var number: String,
    var securityCode: String,
    var printedName: String,
    var credit_limit: Double,
    var availableCreditLimit: Double,
    @CreationTimestamp
    var createdAt: LocalDateTime = LocalDateTime.now(),
//    @CreationTimestamp
//    var updatedAt: LocalDateTime = LocalDateTime.now(),
) {

    // fun toCreditCard() : CreditCard {} // This function will return the domain object

}
