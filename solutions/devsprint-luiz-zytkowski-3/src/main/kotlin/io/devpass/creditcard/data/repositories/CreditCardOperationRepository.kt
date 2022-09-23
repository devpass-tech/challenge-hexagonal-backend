package io.devpass.creditcard.data.repositories

import io.devpass.creditcard.data.entities.CreditCardOperationEntity
import org.springframework.data.repository.CrudRepository

interface CreditCardOperationRepository : CrudRepository<CreditCardOperationEntity, String> {

}