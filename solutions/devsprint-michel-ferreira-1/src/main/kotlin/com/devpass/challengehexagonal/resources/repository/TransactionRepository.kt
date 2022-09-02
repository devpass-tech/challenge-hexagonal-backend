package com.devpass.challengehexagonal.resources.repository

import com.devpass.challengehexagonal.resources.repository.entity.TransactionEntity
import org.springframework.data.repository.CrudRepository

interface TransactionRepository : CrudRepository<TransactionEntity, Long> {

    fun findByAccountId(accountId: Long): List<TransactionEntity>
}