package com.devpass.challengehexagonal.domain.model

import java.time.LocalDate

data class Client(
    val account: Account,
    val birthDate: LocalDate?,
    val id: Long? = null,
    val name: String,
){}