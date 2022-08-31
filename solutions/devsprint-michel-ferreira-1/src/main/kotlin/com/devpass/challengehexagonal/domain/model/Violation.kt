package com.devpass.challengehexagonal.domain.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

class Transaction(
    establishment: String,
    createdAt: LocalDateTime = LocalDateTime.now(),
    value: Double
)