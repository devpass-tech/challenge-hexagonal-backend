package com.devpass.challengehexagonal.resources.repository.database.client

import com.devpass.challengehexagonal.resources.repository.entity.TransactionEntity
import java.time.LocalDateTime
import org.springframework.data.repository.CrudRepository
import java.math.BigDecimal
import java.time.LocalDateTime

interface TransactionSpringDataRepository : CrudRepository<TransactionEntity, Long> {

    fun findByAccountId(accountId: Long): List<TransactionEntity>

     fun existsTransactionsByEstablishmentAndDateRage(
         startDateTime: LocalDateTime,
         endDate: LocalDateTime,
         amount: BigDecimal,
         establishment: String): Boolean

    fun findByAccountIdAndEstablishmentAndTransactionDateBetween(
        accountId: Long,
        establishment: String,
        startDateTime: LocalDateTime,
        endDateTime: LocalDateTime,
    ): List<TransactionEntity>
}