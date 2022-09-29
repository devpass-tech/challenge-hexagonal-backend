package io.devpass.creditcard.data.repositories

import io.devpass.creditcard.data.entities.CreditCardOperationEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CreditCardOperationRepository : CrudRepository<CreditCardOperationEntity, String> {

    @Query("SELECT ccoe FROM CreditCardOperationEntity ccoe WHERE ccoe.creditCard = ?1 AND ccoe.month = ?2 AND ccoe.year = ?3")
    fun listByPeriod(creditCardId: String, month: Int, year: Int): List<CreditCardOperationEntity>
}