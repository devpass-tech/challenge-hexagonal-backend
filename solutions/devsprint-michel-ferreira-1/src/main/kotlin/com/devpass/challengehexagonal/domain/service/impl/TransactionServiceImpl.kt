package com.devpass.challengehexagonal.domain.service.impl

import com.devpass.challengehexagonal.domain.model.Transaction
import com.devpass.challengehexagonal.domain.ports.ClientRepositoryPort
import com.devpass.challengehexagonal.domain.ports.TransactionRepositoryPort
import com.devpass.challengehexagonal.domain.service.TransactionServicePort
import org.springframework.stereotype.Service

@Service
class TransactionServiceImpl(
    val clientRepositoryPort: ClientRepositoryPort,
    val transactionRepositoryPort: TransactionRepositoryPort
) : TransactionServicePort {

    override fun processTransaction(clientId: Long, transaction: Transaction) {
        // lancar excecao ClientNotFoundException caso nao achar o client
        TODO("Not yet implemented")
    }
}
