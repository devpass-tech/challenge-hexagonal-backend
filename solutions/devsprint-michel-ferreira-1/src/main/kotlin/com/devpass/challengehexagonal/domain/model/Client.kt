package com.devpass.challengehexagonal.domain.model

import java.time.LocalDate

data class Client(
    val id: Long? = null,
    val name: String,
    val birthDate: LocalDate?,
    val account: Account? = null,
)