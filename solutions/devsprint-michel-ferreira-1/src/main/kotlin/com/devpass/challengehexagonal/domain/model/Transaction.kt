package com.devpass.challengehexagonal.domain.model

import java.time.LocalDateTime

class Transaction(
    establishment: String,
    createdAt: LocalDateTime = LocalDateTime.now(),
    value: Double
)