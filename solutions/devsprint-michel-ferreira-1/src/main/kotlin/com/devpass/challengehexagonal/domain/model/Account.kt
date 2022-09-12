package com.devpass.challengehexagonal.domain.model

data class Account(
    val id: Long? = null,
    val active: Boolean,
    val accountNumber: Long,
    val balance: Double,
    val transactionHistory: List<Transaction> = emptyList(),
)