package com.devpass.challengehexagonal.domain.service.impl

import com.devpass.challengehexagonal.domain.model.Client
import com.devpass.challengehexagonal.domain.ports.ClientRepositoryPort
import com.devpass.challengehexagonal.domain.service.ClientManagerServicePort
import org.springframework.stereotype.Service

@Service
class ClientManagerServiceImpl(
    private val clientRepositoryPort: ClientRepositoryPort,
) : ClientManagerServicePort {

    override fun getClient(clientId: Long): Client {
        // lancar excecao ClientNotFoundException caso nao achar o client
        TODO("Not yet implemented")
    }

    override fun listClients(): List<Client> {
        return clientRepositoryPort.list()
    }

    override fun saveClient(client: Client) {
        TODO("Not yet implemented")
    }
}
