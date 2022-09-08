package com.devpass.challengehexagonal.domain.ports

import com.devpass.challengehexagonal.domain.model.Client

interface ClientRepositoryPort {

    fun getById(clientId: Long): Client?

    fun list(): List<Client>

    fun save(client: Client)
}
