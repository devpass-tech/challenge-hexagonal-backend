package io.devpass.creditcard.data.entities

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class CreditCardEntity(
    @Id val id: String,
) {

    // fun toCreditCard() : CreditCard {} // This function will return the domain object

}
