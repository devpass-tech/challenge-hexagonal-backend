package com.devpass.challengehexagonal.domain.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class ClientEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String,

    val birthDate: LocalDateTime,

    val account: AccountEntity,

//    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
//    @JoinColumn(name = "account_id", referencedColumnName = "account")
)
