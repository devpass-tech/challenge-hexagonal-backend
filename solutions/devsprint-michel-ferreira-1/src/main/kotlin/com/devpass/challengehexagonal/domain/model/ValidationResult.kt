package com.devpass.challengehexagonal.domain.model

data class ValidationResult(
    val violations: MutableList<Violation> = mutableListOf()
)
