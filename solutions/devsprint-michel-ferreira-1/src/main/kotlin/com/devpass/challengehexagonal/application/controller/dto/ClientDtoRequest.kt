package com.devpass.challengehexagonal.application.controller.dto

import java.time.LocalDate

data class ClientDtoRequest (
    val name: String,
    val birthDate: LocalDate?,
)