package com.devpass.challengehexagonal.resources.repository.database.client

import com.devpass.challengehexagonal.resources.repository.entity.TransactionEntity
import org.springframework.data.repository.CrudRepository
import java.math.BigDecimal
import java.time.LocalDateTime

interface TransactionSpringDataRepository : CrudRepository<TransactionEntity, Long> {

    fun findByAccountId(accountId: Long): List<TransactionEntity>

    fun existsByAccountAndValueAndEstablishmentAndTransactionDateBetween(
        accountId: Long,
        value: BigDecimal,
        establishment: String,
        startDate: LocalDateTime,
        endDate: LocalDateTime,
    ) : Boolean

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

