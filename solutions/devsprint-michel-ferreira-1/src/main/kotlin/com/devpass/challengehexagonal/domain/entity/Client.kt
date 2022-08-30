package com.devpass.challengehexagonal.domain.entity

import java.math.BigDecimal
import javax.persistence.*

@Entity
data class Client(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String,

    var balance: BigDecimal,

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "client_id")
    val transactions: MutableList<Transaction> = mutableListOf()
)
