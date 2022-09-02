package com.devpass.challengehexagonal.domain.service

import com.devpass.challengehexagonal.domain.model.Transaction
import com.devpass.challengehexagonal.domain.ports.ClientRepositoryPort
import com.devpass.challengehexagonal.domain.ports.TransactionRepositoryPort
import org.springframework.stereotype.Service

@Service
class TransactionService(
    val clientRepositoryPort: ClientRepositoryPort,
    val transactionRepositoryPort: TransactionRepositoryPort
) {

    fun processTransaction(clientId: Long, transaction: Transaction) {
        TODO("Not yet implemented")
    }
}
