package com.devpass.challengehexagonal.domain.gateway

import com.devpass.challengehexagonal.resources.repository.TransactionRepository

interface TransactionAdapter {
    val transactionRepository: TransactionRepository
}