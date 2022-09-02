package com.devpass.challengehexagonal.domain.model

import java.math.BigDecimal
import java.time.LocalDateTime

data class Transaction(
    val establishment: String,
    val value: BigDecimal,
    val transactionDate: LocalDateTime = LocalDateTime.now()
)