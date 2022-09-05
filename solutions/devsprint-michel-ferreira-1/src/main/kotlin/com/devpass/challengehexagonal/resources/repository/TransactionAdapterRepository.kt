package com.devpass.challengehexagonal.resources.repository

import com.devpass.challengehexagonal.domain.model.Transaction
import com.devpass.challengehexagonal.domain.ports.TransactionRepositoryPort
import com.devpass.challengehexagonal.resources.repository.database.client.TransactionSpringDataRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class TransactionAdapterRepository(
        val repository: TransactionSpringDataRepository
) : TransactionRepositoryPort {

    override fun getTransactionsByAccount(accountId: Long): List<Transaction> {
        return repository.findByAccountId(accountId).map { it.toDomain() }
    }

    override fun getFirstTransactionByDate(accountId: Long, dateTime: LocalDateTime): Transaction? {
        return repository.findByAccountIdAndTransactionDate(accountId, dateTime)?.toDomain()
    }
}