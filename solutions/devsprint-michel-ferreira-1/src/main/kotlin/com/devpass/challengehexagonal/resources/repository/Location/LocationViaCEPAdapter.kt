package com.devpass.challengehexagonal.resources.repository.Location

import com.devpass.challengehexagonal.domain.model.Location
import com.devpass.challengehexagonal.domain.ports.LocationPort
import com.devpass.challengehexagonal.resources.exceptions.ZipCodeException
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class LocationViaCEPAdapter(
    val restTemplate: RestTemplate
) : LocationPort {
    override fun getLocationByZipCode(zipCode: String): Location {
        val locationResponse: LocationViaCEPResponse = restTemplate.getForEntity(
            "https://viacep.com.br/ws?cep=$zipCode",
            LocationViaCEPResponse::class.java
        ).body ?: throw ZipCodeException("ZipCodeNotFoundException")


        val location = locationResponse.let {
            Location(
                streetName = it.logradouro,
                number = it.cep
            )
        }
        return location
    }
}