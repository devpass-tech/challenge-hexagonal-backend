package com.devpass.challengehexagonal.domain.model

data class Account(
    val accountNumber: Int,
    val balance: Double,
    val transactionHistory: List<Transaction>
){}