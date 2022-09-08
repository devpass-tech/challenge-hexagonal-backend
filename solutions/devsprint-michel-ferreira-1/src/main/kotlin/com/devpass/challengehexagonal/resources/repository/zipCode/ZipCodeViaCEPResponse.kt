package com.devpass.challengehexagonal.resources.repository.zipCode

data class ZipCodeViaCEPResponse(
    val cep: String,
    val logradouro: String,
    val bairro: String,
    val localidade: String,
    val uf: String
)