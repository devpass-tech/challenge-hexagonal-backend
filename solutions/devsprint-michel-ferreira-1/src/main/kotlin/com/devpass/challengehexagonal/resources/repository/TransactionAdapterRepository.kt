package com.devpass.challengehexagonal.resources.repository

import com.devpass.challengehexagonal.domain.model.Transaction
import com.devpass.challengehexagonal.domain.ports.TransactionRepositoryPort
import com.devpass.challengehexagonal.resources.repository.database.client.TransactionSpringDataRepository
import org.springframework.stereotype.Repository
import java.math.BigDecimal
import java.time.LocalDateTime

@Repository
class TransactionAdapterRepository(
    val repository: TransactionSpringDataRepository
) : TransactionRepositoryPort {

    override fun getTransactionsByAccount(accountId: Long): List<Transaction> {
        return repository.findByAccountId(accountId).map { it.toDomain() }
    }

    override fun getTransactionByDateRange(
        clientId: Long,
        value: BigDecimal,
        establishment: String,
        startDate: LocalDateTime,
        endDate: LocalDateTime,
    ): Boolean {
        return repository.existsByAccountAndValueAndEstablishmentAndTransactionDateBetween(
            startDate = startDate,
            endDate = endDate,
            accountId = clientId,
            value = value,
            establishment = establishment,
        )
    }
}