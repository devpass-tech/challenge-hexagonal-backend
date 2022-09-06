package com.devpass.challengehexagonal.resources.repository.database.client

import com.devpass.challengehexagonal.resources.repository.entity.TransactionEntity
import java.time.LocalDateTime
import org.springframework.data.repository.CrudRepository

interface TransactionSpringDataRepository : CrudRepository<TransactionEntity, Long> {

    fun findByAccountId(accountId: Long): List<TransactionEntity>
    fun findByAccountIdAndEstablishmentAndTransactionDateBetween(
        accountId: Long,
        establishment: String,
        startDateTime: LocalDateTime,
        endDateTime: LocalDateTime,
    ): List<TransactionEntity>

    fun findTopByAccountIdAndTransactionDateBetweenOrderByTransactionDateAsc (
            accountId: Long,
            date: LocalDateTime,
            startOfTheNextDay: LocalDateTime,
    ): TransactionEntity?
}

