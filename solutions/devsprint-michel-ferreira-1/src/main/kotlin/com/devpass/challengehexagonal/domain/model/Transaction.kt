package com.devpass.challengehexagonal.domain.model

import java.time.LocalDateTime

class Transaction(
    establishment: String,
    transaction_date: LocalDateTime = LocalDateTime.now(),
    value: Double
)