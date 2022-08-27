package com.devpass.challengehexagonal.model.service

import com.devpass.challengehexagonal.controller.dto.TransactionRequestDto
import com.devpass.challengehexagonal.model.repository.ClientRepository
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
