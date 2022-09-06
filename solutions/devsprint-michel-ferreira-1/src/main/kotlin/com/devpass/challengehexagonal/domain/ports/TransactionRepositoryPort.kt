package com.devpass.challengehexagonal.domain.ports

import com.devpass.challengehexagonal.domain.model.Transaction
import java.time.LocalDateTime

interface TransactionRepositoryPort {

    fun getTransactionsByAccount(
        accountId: Long,
    ): List<Transaction>

    fun getTransactionByDateRange(
        accountId: Long,
        establishment: String,
        startDate: LocalDateTime,
        endDate: LocalDateTime,
    ): List<Transaction>

    fun getFirstTransactionByDate(
            accountId: Long,
            dateTime: LocalDateTime
    ): Transaction?
}
