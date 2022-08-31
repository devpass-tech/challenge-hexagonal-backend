package com.devpass.challengehexagonal.domain.model

import java.time.LocalDate
import java.util.UUID

class Client(
    id: UUID = UUID.randomUUID(),
    name: String,
    birth_date: LocalDate?
)