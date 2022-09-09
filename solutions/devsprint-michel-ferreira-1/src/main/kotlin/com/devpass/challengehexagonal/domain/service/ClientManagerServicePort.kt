package com.devpass.challengehexagonal.domain.service

import com.devpass.challengehexagonal.application.controller.dto.ClientDtoRequest
import com.devpass.challengehexagonal.domain.model.Client

interface ClientManagerServicePort {

    fun getClient(clientId: Long): Client

    fun listClients(): List<Client>

    fun saveClient(client: Client)

    fun createNewClient(client: ClientDtoRequest)
}
