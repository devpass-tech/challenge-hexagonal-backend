package io.devpass.creditcard.data.entities

import io.devpass.creditcard.domain.objects.CreditCardOperation
import java.time.LocalDateTime
import org.hibernate.annotations.CreationTimestamp
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "credit_card_operation")
data class CreditCardOperationEntity(
        @Id
        var id: String,
        var type: String,
        var value: Double,
        var description: String,
        var month: Int,
        var year: Int,
        @CreationTimestamp
        var createdAt: LocalDateTime = LocalDateTime.now(),
) {
    fun toCreditCardOperation(): CreditCardOperation {
        return CreditCardOperation(
            this.id,
            this.credit_card,
            this.type,
            this.value,
            this.description,
            this.month,
            this.year,
            this.createdAt
        )
    }
}