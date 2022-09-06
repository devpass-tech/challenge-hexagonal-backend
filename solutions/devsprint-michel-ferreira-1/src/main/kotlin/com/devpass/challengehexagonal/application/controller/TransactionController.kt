package com.devpass.challengehexagonal.application.controller

import com.devpass.challengehexagonal.domain.model.Transaction
import com.devpass.challengehexagonal.domain.ports.TransactionRepositoryPort
import com.devpass.challengehexagonal.domain.service.TransactionServicePort
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("transactions")
class TransactionController(
    val transactionServicePort: TransactionServicePort
) {

    @PostMapping
    fun postTransaction(): List<Transaction> {
        TODO("Not yet implemented")
    }
}
