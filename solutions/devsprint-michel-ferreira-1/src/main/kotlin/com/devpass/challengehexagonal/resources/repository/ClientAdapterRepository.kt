package com.devpass.challengehexagonal.resources.repository

import com.devpass.challengehexagonal.domain.ports.ClientRepositoryPort
import org.springframework.stereotype.Repository

@Repository
class ClientAdapterRepository(
    val repository: ClientRepository
) : ClientRepositoryPort {

}