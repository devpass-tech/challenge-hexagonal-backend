package com.devpass.challengehexagonal.resources.repository.database.client

import com.devpass.challengehexagonal.resources.repository.entity.TransactionEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.math.BigDecimal
import java.time.LocalDateTime

interface TransactionSpringDataRepository : CrudRepository<TransactionEntity, Long> {

    fun findByAccountId(accountId: Long): List<TransactionEntity>

    fun countTransaction(startDateTime: LocalDateTime, endDate: LocalDateTime, amount: BigDecimal, establishment: String): Boolean
}