package com.devpass.challengehexagonal.resources.repository.database.client

import com.devpass.challengehexagonal.resources.repository.entity.TransactionEntity
import org.springframework.data.repository.CrudRepository
import java.time.LocalDateTime

interface TransactionSpringDataRepository : CrudRepository<TransactionEntity, Long> {

    fun findByAccountId(accountId: Long): List<TransactionEntity>

    fun findByAccountIdAndTransactionDate (
            accountId: Long,
            dateTime: LocalDateTime = LocalDateTime.now()
    ): TransactionEntity?
}