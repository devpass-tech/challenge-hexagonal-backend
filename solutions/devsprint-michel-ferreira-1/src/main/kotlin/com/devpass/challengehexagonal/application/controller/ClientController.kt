package com.devpass.challengehexagonal.application.controller

import com.devpass.challengehexagonal.domain.model.Client
import com.devpass.challengehexagonal.domain.service.ClientManagerServicePort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("clients")
class ClientController(
    val clientManagerServicePort: ClientManagerServicePort,
) {
    @GetMapping
    fun listAllClients(): ResponseEntity<List<Client>> {
        val listOfClients = clientManagerServicePort.listClients()
        return ResponseEntity.ok(listOfClients)
    }
}