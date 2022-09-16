package io.devpass.creditcard.data.entities

import io.devpass.creditcard.data.CreditCardOperationDAO
import io.devpass.creditcard.domain.objects.CreditCardOperation
import java.time.LocalDateTime
import org.hibernate.annotations.CreationTimestamp
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
) {
    fun toCreditCardOperation(): CreditCardOperation {
        return CreditCardOperation(id = this.id, credit_card=this.credit_card, type=this.type,value=this.value,description=this.description)
    }
}