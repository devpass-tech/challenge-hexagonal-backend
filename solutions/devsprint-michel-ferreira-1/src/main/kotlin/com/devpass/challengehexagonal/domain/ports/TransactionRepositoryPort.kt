package com.devpass.challengehexagonal.domain.ports

import com.devpass.challengehexagonal.domain.model.Transaction

interface TransactionRepositoryPort {

    fun getTransactionsByAccount(
        accountId: Long
    ): List<Transaction>

}
