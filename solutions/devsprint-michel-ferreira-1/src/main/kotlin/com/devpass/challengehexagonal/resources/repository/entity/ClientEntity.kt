package com.devpass.challengehexagonal.resources.repository.entity

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.OneToOne


@Entity
data class ClientEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String,

    val birthDate: LocalDate,

    @OneToOne
    val account: AccountEntity,
)
