package io.devpass.creditcard.data.repositories

import io.devpass.creditcard.data.entities.CreditCardEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CreditCardRepository : CrudRepository<CreditCardEntity, String>{

    @Query("SELECT cce FROM CreditCardEntity  CCE WHERE cce.owner = ?1")
    fun searchCreditCardEntityByOwner(cpf : String) : List<CreditCardEntity>
}
