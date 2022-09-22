package io.devpass.creditcard.domain.objects

import java.time.LocalDateTime

data class CreditCardOperation(
    var id: String,
    var creditCardId: String,
    var type: String,
    var value: Double,
    var description: String,
    var createdAt: LocalDateTime = LocalDateTime.now(),
)
