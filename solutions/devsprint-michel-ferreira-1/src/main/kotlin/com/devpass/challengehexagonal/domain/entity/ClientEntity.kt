package com.devpass.challengehexagonal.domain.entity

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany


@Entity
data class ClientEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String,

    val birthDate: LocalDate,

    @OneToMany
    val account: AccountEntity,
)
