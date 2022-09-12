package com.devpass.challengehexagonal.domain.ports

import com.devpass.challengehexagonal.domain.model.Transaction
import java.time.LocalDate
import java.math.BigDecimal
import java.time.LocalDateTime

interface TransactionRepositoryPort {

    fun getTransactionsByAccount(
        accountId: Long,
    ): List<Transaction>

    fun getTransactionByDateRange(
        clientId: Long,
        value: BigDecimal,
        establishment: String,
        startDate: LocalDateTime,
        endDate: LocalDateTime,
    ) : Boolean

    fun getTransactionByDateRange(
        accountId: Long,
        establishment: String,
        startDate: LocalDateTime,
        endDate: LocalDateTime,
    ): List<Transaction>

    fun getFirstTransactionByDate(
            accountId: Long,
            date: LocalDate,
    ): Transaction?

    fun getTransactionByDateTime(
        accountId: Long,
        dateTime: LocalDateTime,
    ): List<Transaction>
}
