package com.devpass.challengehexagonal.resources.repository.entity

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class TransactionEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val establishment: String,

    val transactionDate: LocalDateTime,

    val value: BigDecimal,

    @ManyToOne(fetch = FetchType.LAZY)
    val account: AccountEntity
)
