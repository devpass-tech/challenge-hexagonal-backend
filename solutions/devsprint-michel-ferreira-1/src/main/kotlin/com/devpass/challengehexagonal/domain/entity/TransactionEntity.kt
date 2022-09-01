package com.devpass.challengehexagonal.domain.entity

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

    val account: AccountEntity,

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "account_id", referencedColumnName = "account")
)
