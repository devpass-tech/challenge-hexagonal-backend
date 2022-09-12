package com.devpass.challengehexagonal.resources.repository

import com.devpass.challengehexagonal.domain.model.Client
import com.devpass.challengehexagonal.domain.ports.ClientRepositoryPort
import com.devpass.challengehexagonal.resources.repository.database.client.ClientSpringDataRepository
import org.springframework.stereotype.Repository

@Repository
class ClientAdapterRepository(
    val repository: ClientSpringDataRepository,
) : ClientRepositoryPort {
    override fun getById(clientId: Long): Client? {
        TODO("Not yet implemented")
    }

    override fun list(): List<Client> {
        return repository.findAll().map { it.toDomain() }
    }

    override fun save(client: Client) {
        TODO("Not yet implemented")
    }

}