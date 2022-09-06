package com.devpass.challengehexagonal.domain.ports

import com.devpass.challengehexagonal.domain.model.Transaction
import java.math.BigDecimal
import java.time.LocalDateTime

interface TransactionRepositoryPort {

    fun getTransactionsByAccount(
        accountId: Long
    ): List<Transaction>

    fun existsByClientIdAndAmountAndEstablishmentAndTransactionDateBetween(
        clientId: Long,
        amount: BigDecimal,
        establishment: String,
        startDate: LocalDateTime,
        endDate: LocalDateTime,
    ) : Boolean
}
