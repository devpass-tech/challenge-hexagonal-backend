package com.devpass.challengehexagonal.domain.model

class Account(
    number: Int,
    balance_available: Double,
    transaction_history: List<Transaction>
)