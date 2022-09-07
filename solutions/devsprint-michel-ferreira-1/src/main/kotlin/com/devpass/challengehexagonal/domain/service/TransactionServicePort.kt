package com.devpass.challengehexagonal.domain.service

import com.devpass.challengehexagonal.domain.model.Transaction

interface TransactionServicePort {

    fun processTransaction(clientId: Long, transaction: Transaction)
}