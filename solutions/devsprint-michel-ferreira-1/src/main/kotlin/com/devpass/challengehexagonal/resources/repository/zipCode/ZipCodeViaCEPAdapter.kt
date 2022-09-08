package com.devpass.challengehexagonal.resources.repository.zipCode

import com.devpass.challengehexagonal.domain.model.Address
import com.devpass.challengehexagonal.domain.ports.ZipCodePort
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class ZipCodeViaCEPAdapter(
    val restTemplate: RestTemplate
) : ZipCodePort {
    override fun getZipCode(zipCode: String): Address {
        val addressResponse: ZipCodeViaCEPResponse? = restTemplate.getForEntity(
            "https://viacep.com.br/ws?cep=$zipCode",
            ZipCodeViaCEPResponse::class.java
        ).body ?: throw Exception("Address not found")


        val address = addressResponse?.let {
            Address(
                city = it.localidade,
                district = it.bairro,
                postalCode = it.cep,
                street = it.logradouro,
                state = it.uf
            )
        }
        return address ?: throw Exception("")
    }
}