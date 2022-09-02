package com.devpass.challengehexagonal.resources.repository

import com.devpass.challengehexagonal.domain.ports.ClientRepositoryPort
import com.devpass.challengehexagonal.resources.repository.database.client.ClientSpringDataRepository
import org.springframework.stereotype.Repository

@Repository
class ClientAdapterRepository(
    val repository: ClientSpringDataRepository
) : ClientRepositoryPort {

}