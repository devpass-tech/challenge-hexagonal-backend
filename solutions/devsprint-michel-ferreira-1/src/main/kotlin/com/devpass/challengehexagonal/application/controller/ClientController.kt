package com.devpass.challengehexagonal.application.controller

import com.devpass.challengehexagonal.application.DTO.ClientResponseDTO
import com.devpass.challengehexagonal.domain.service.ClientManagerServicePort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("clients")
class ClientController(
    val clientManagerServicePort: ClientManagerServicePort,
) {
    @GetMapping
    fun listAllClients(): List<ClientResponseDTO> {
        val listOfClients = clientManagerServicePort.listClients()
        return listOfClients.map { ClientResponseDTO(it) }
    }
}