package com.devpass.challengehexagonal.domain.service

import com.devpass.challengehexagonal.application.controller.dto.TransactionRequestDto
import com.devpass.challengehexagonal.resources.repository.ClientAdapterRepository
import org.springframework.stereotype.Service

@Service
class TransactionService(
    val clientAdapterRepository: ClientAdapterRepository
) {

    fun processTransaction(transactionRequestDto: TransactionRequestDto) {
        clientAdapterRepository.getClientById(transactionRequestDto.clientId)
            .apply {
                this.transactions.add(transactionRequestDto.toTransaction())
                this.balance -= transactionRequestDto.amount
                clientAdapterRepository.saveClient(this)
            }
    }
}
