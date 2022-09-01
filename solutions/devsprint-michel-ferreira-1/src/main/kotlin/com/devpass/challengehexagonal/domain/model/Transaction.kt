package com.devpass.challengehexagonal.domain.model

import java.time.LocalDateTime

data class Transaction(
    val establishment: String,
    val value: Double,
    val transactionDate: LocalDateTime = LocalDateTime.now()
)