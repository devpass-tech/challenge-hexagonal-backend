package com.devpass.challengehexagonal.domain.service.impl

import com.devpass.challengehexagonal.domain.model.Client
import com.devpass.challengehexagonal.domain.ports.ClientRepositoryPort
import com.devpass.challengehexagonal.domain.service.ClientManagerServicePort
import org.springframework.stereotype.Service

@Service
class ClientManagerServiceImpl(
    private val clientRepositoryPort: ClientRepositoryPort
) : ClientManagerServicePort {

    override fun getClient(clientId: Long): Client {
        TODO("Not yet implemented")
    }
}
