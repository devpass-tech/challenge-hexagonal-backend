package com.devpass.challengehexagonal.resources.location

data class LocationViaCEPResponse(
    val cep: String,
    val logradouro: String,
    val bairro: String,
    val localidade: String,
    val uf: String
)