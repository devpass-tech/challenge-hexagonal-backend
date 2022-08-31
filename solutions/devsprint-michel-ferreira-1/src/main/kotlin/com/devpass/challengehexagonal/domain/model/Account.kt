package com.devpass.challengehexagonal.domain.model

import java.time.LocalDate
import java.util.UUID

class Client(
    id: UUID,
    name: String,
    birthDate: LocalDate?
)