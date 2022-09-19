package io.devpass.creditcard.data.entities

import io.devpass.creditcard.domain.objects.CreditCard
import java.time.LocalDateTime
import org.hibernate.annotations.CreationTimestamp
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class CreditCardEntity(
        @Id var id: String,
        var owner: String,
        var number: String,
        var securityCode: String,
        var printedName: String,
        var creditLimit: Double,
        var availableCreditLimit: Double,
        @CreationTimestamp
        var createdAt: LocalDateTime = LocalDateTime.now(),
//    @CreationTimestamp
//    var updatedAt: LocalDateTime = LocalDateTime.now(),
) {
    fun toCreditCard(): CreditCard {
        return CreditCard(
                this.id,
                this.owner,
                this.number,
                this.securityCode,
                this.printedName,
                this.creditLimit,
                this.availableCreditLimit,
        )
    }
}

