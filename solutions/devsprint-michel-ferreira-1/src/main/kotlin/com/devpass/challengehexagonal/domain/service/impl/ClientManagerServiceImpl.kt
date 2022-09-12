package com.devpass.challengehexagonal.domain.service.impl

import com.devpass.challengehexagonal.domain.exceptions.ClientNotFoundException
import com.devpass.challengehexagonal.domain.model.Client
import com.devpass.challengehexagonal.domain.ports.ClientRepositoryPort
import com.devpass.challengehexagonal.domain.service.ClientManagerServicePort
import org.springframework.stereotype.Service

@Service
class ClientManagerServiceImpl(
    private val clientRepositoryPort: ClientRepositoryPort
) : ClientManagerServicePort {

    override fun getClient(clientId: Long): Client {
        return clientRepositoryPort.getById(clientId) ?: throw ClientNotFoundException("Cliente não encontrado")
    }

    override fun listClients(): List<Client> {
        return clientRepositoryPort.list()
    }

    override fun saveClient(client: Client) {
        return clientRepositoryPort.save(client)
    }
}
