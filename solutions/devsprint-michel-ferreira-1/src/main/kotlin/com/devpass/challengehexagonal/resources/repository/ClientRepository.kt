package com.devpass.challengehexagonal.resources.repository

import com.devpass.challengehexagonal.resources.repository.entity.ClientEntity
import org.springframework.data.repository.CrudRepository

interface ClientRepository : CrudRepository<ClientEntity, Long> {
}