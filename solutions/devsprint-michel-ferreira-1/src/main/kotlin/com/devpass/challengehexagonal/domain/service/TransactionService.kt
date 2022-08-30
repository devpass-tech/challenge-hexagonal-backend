package com.devpass.challengehexagonal.domain.service

import com.devpass.challengehexagonal.application.controller.dto.TransactionRequestDto
import com.devpass.challengehexagonal.resources.repository.ClientRepository
import org.springframework.stereotype.Service

@Service
class TransactionService(
    val clientRepository: ClientRepository
) {

    fun processTransaction(transactionRequestDto: TransactionRequestDto) {
        clientRepository.getClientById(transactionRequestDto.clientId)
            .apply {
                this.transactions.add(transactionRequestDto.toTransaction())
                this.balance -= transactionRequestDto.amount
                clientRepository.saveClient(this)
            }
    }
}
