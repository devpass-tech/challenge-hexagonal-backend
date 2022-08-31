package com.devpass.challengehexagonal.domain.model

class Account(
    account_number: Int,
    balance: Double,
    transaction_history: List<Transaction>
)