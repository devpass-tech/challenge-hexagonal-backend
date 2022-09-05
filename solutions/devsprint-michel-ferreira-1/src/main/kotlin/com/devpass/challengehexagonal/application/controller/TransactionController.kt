package com.devpass.challengehexagonal.application.controller

import com.devpass.challengehexagonal.domain.model.Transaction
import com.devpass.challengehexagonal.domain.ports.TransactionRepositoryPort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("transactions")
class TransactionController(
        //TODO: Em um segundo momento essa injeção será alterada pela Port correta (TransactionServicePort)
        //Inclusa aqui apenas para facilitar os testes
        val transactionRepositoryPort: TransactionRepositoryPort
) {

    @GetMapping("/client/{clientId}")
    fun getTransactionsByClient(@PathVariable(value = "clientId") clientId: Long): List<Transaction> {
        return transactionRepositoryPort.getTransactionsByAccount(clientId)
    }

    @GetMapping("/{accountId}/{dateTime}")
    fun findByAccountIdAndTransactionDate(
            @PathVariable(value = "accountId")
            accountId: Long,

            @PathVariable(value = "dateTime")
            dateTime: LocalDateTime,
    ): Transaction? {
        return transactionRepositoryPort.getFirstTransactionByDate(accountId, dateTime)
    }
}