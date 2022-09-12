package com.devpass.challengehexagonal.resources.repository.database.client

import com.devpass.challengehexagonal.resources.repository.entity.ClientEntity
import org.springframework.data.repository.CrudRepository

interface ClientSpringDataRepository : CrudRepository<ClientEntity, Long>