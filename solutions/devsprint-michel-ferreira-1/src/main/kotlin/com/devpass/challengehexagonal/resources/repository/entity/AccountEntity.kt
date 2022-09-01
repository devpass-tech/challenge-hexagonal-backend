package com.devpass.challengehexagonal.resources.repository.entity

import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "account")
data class AccountEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val accountNumber: Long? = null,

    var balance: BigDecimal,

    @OneToMany(cascade = [(CascadeType.ALL)], mappedBy = "transaction")
    val transactions: MutableList<TransactionEntity> = mutableListOf()
)
