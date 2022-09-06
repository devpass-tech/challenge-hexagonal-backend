package com.devpass.challengehexagonal.application.controller

import com.devpass.challengehexagonal.domain.model.Transaction
import com.devpass.challengehexagonal.domain.ports.TransactionRepositoryPort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.devpass.challengehexagonal.domain.service.TransactionServicePort
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("transactions")
class TransactionController(
        //TODO: Em um segundo momento essa injeção será alterada pela Port correta (TransactionServicePort)
        //Inclusa aqui apenas para facilitar os testes
        val transactionRepositoryPort: TransactionRepositoryPort,
        val transactionServicePort: TransactionServicePort
) {

    @PostMapping
    fun postTransaction(): List<Transaction> {
        TODO("Not yet implemented")
    }

    @GetMapping("/{accountId}/{date}")
    fun findByAccountIdAndTransactionDate(
            @PathVariable(value = "accountId")
            accountId: Long,

            @PathVariable(value = "date")
            date: LocalDate,
    ): Transaction? {
        return transactionRepositoryPort.getFirstTransactionByDate(accountId, date)
    }
}