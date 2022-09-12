package com.devpass.challengehexagonal.application.controller

import com.devpass.challengehexagonal.application.controller.dto.ClientDtoRequest
import com.devpass.challengehexagonal.domain.service.ClientManagerServicePort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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

    @PostMapping("/new-client")
    fun createNewClient(
        @RequestBody clientDtoRequest : ClientDtoRequest
    ) : ResponseEntity<String> {
        clientManagerServicePort.saveClient(client:Client)
        return ResponseEntity.ok("Cliente criado com sucesso!")

    @GetMapping
    fun listAllClients(): List<ClientResponseDTO> {
        val listOfClients = clientManagerServicePort.listClients()
        return listOfClients.map { ClientResponseDTO(it) }
    }
}