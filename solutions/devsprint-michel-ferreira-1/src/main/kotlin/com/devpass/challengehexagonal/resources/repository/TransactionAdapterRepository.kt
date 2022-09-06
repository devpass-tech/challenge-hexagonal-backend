package com.devpass.challengehexagonal.resources.repository

import com.devpass.challengehexagonal.domain.model.Transaction
import com.devpass.challengehexagonal.domain.ports.TransactionRepositoryPort
import com.devpass.challengehexagonal.resources.repository.database.client.TransactionSpringDataRepository
import org.springframework.stereotype.Repository
import java.math.BigDecimal
import java.time.LocalDateTime

@Repository
class TransactionAdapterRepository(
    private val repository: TransactionSpringDataRepository,
) : TransactionRepositoryPort {

    override fun getTransactionsByAccount(accountId: Long): List<Transaction> {
        return repository.findByAccountId(accountId).map { it.toDomain() }
    }

    override fun existsByClientIdAndAmountAndEstablishmentAndTransactionDateBetween(
        clientId: Long,
        amount: BigDecimal,
        establishment: String,
        startDate: LocalDateTime,
        endDate: LocalDateTime,
    ): Boolean {
        return repository.existsTransactionsByEstablishmentAndDateRage(
            startDate,
            endDate,
            amount,
            establishment,
        )
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
}