package com.devpass.challengehexagonal.resources.repository

import com.devpass.challengehexagonal.domain.model.Client
import com.devpass.challengehexagonal.domain.ports.ClientRepositoryPort
import com.devpass.challengehexagonal.resources.repository.database.client.ClientSpringDataRepository
import org.springframework.stereotype.Repository


@Repository
class ClientAdapterRepository(
    val repository: ClientSpringDataRepository
    val repository: ClientSpringDataRepository,
) : ClientRepositoryPort {
    override fun getById(clientId: Long): Client? {
        val clientEntity = repository.findById(clientId).let { if (it.isPresent) it.get() else null }
        return clientEntity?.toDomain()
    }

    override fun list(): List<Client> {
        return repository.findAll().map { it.toDomain() }
    }

    override fun save(client: Client) {
        val clientSave = repository.save(client)


    }

}