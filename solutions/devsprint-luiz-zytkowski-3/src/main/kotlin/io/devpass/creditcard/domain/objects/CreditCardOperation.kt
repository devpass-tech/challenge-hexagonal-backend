package io.devpass.creditcard.domain.objects

import java.time.LocalDateTime
import java.util.UUID

data class CreditCardOperation(
    var id: String = UUID.randomUUID().toString(),
    var creditCard: String,
    var type: String,
    var value: Double,
    var description: String,
    var month: Int,
    var year: Int,
    var createdAt: LocalDateTime = LocalDateTime.now(),
)
