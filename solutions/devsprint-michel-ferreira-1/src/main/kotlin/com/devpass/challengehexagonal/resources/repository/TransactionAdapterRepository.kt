package com.devpass.challengehexagonal.resources.repository

import com.devpass.challengehexagonal.domain.model.Transaction
import com.devpass.challengehexagonal.domain.ports.TransactionRepositoryPort
import com.devpass.challengehexagonal.resources.repository.database.client.TransactionSpringDataRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.time.LocalDateTime

@Repository
class TransactionAdapterRepository(
    private val repository: TransactionSpringDataRepository,
) : TransactionRepositoryPort {

    override fun getTransactionsByAccount(accountId: Long): List<Transaction> {
        return repository.findByAccountId(accountId).map { it.toDomain() }
    }

    override fun getTransactionByDateRange(
        accountId: Long,
        establishment: String,
        startDate: LocalDateTime,
        endDate: LocalDateTime,
    ): List<Transaction> {
        return repository.findByAccountIdAndEstablishmentAndTransactionDateBetween(
            accountId = accountId,
            establishment = establishment,
            startDateTime = startDate,
            endDateTime = endDate,
        ).map { it.toDomain() }
    }

    override fun getFirstTransactionByDate(accountId: Long, date: LocalDate): Transaction? {
        val startOfDay = date.atStartOfDay()
        val startOfTheNextDay = date.plusDays(1).atStartOfDay()
        return repository.findTopByAccountIdAndTransactionDateBetweenOrderByTransactionDateAsc(accountId, startOfDay, startOfTheNextDay)?.toDomain()
    }
}