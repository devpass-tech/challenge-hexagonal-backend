package com.devpass.challengehexagonal.domain.model

data class Account(
    val id: Long? = null,
    val active: Boolean,
    val accountNumber: Int,
    val balance: Double,
    val transactionHistory: List<Transaction>
){}