package com.devpass.challengehexagonal.resources.repository.zipCode

import com.devpass.challengehexagonal.domain.model.ZipCode
import com.devpass.challengehexagonal.domain.ports.ZipCodePort
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class ZipCodeViaCEPAdapter(
    val restTemplate: RestTemplate
) : ZipCodePort {
    override fun getZipCode(zipCode: String): ZipCode {
        val zipCodeResponse: ZipCodeViaCEPResponse? = restTemplate.getForEntity(
            "https://viacep.com.br/ws?cep=$zipCode",
            ZipCodeViaCEPResponse::class.java
        ).body ?: throw Exception("ZipCode not found")


        val zipCode = zipCodeResponse?.let {
            ZipCode(
                city = it.localidade,
                district = it.bairro,
                postalCode = it.cep,
                street = it.logradouro,
                state = it.uf
            )
        }
        return zipCode ?: throw Exception("")
    }
}