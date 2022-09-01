package com.devpass.challengehexagonal.domain.entity

import java.math.BigDecimal
import javax.persistence.*

@Entity
data class AccountEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val accountNumber: Long? = null,

    var balance: BigDecimal,

    @OneToMany(cascade = [(CascadeType.ALL)])
    val transactions: MutableList<TransactionEntity> = mutableListOf()
)
