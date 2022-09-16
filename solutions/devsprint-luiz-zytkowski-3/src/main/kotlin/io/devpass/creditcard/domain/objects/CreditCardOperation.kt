package io.devpass.creditcard.domain.objects

import java.time.LocalDateTime

data class CreditCardOperation(
        var id: String,
        var credit_card: String,
        var type: String,
        var value: Double,
        var description: String,
        var createdAt: LocalDateTime?,
)