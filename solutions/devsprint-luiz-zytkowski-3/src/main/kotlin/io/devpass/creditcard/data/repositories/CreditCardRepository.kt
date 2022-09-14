package io.devpass.creditcard.data.repositories

import io.devpass.creditcard.data.entities.CreditCardEntity
import org.springframework.data.repository.CrudRepository

interface CreditCardRepository : CrudRepository<CreditCardEntity, String>
