package com.devpass.challengehexagonal.resources.repository.database.client

import com.devpass.challengehexagonal.resources.repository.entity.TransactionEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.time.LocalDateTime

interface TransactionSpringDataRepository : CrudRepository<TransactionEntity, Long> {

    fun findByAccountId(accountId: Long): List<TransactionEntity>

    //query pra pegar a qtdade de transactions entre duas datas
    @Query("select count(transaction.id) from transaction where ")
    fun countTransaction(startDateTime: LocalDateTime, endDate: LocalDateTime, amount: Long, establishment: String): Long




//     override fun count(transaction: Long): Long {
//        TODO("Not yet implemented")
//    }
}