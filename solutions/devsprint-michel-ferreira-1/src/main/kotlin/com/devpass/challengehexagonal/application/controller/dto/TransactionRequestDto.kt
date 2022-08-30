package com.devpass.challengehexagonal.application.controller.dto

import com.devpass.challengehexagonal.domain.entity.Transaction
import java.math.BigDecimal
import java.time.LocalDateTime

data class TransactionRequestDto(
    val clientId: Long,
    val merchant: String,
    val amount: BigDecimal
) {
    fun toTransaction() = Transaction(
        merchant = merchant,
        amount = amount,
        time = LocalDateTime.now()
    )
}
