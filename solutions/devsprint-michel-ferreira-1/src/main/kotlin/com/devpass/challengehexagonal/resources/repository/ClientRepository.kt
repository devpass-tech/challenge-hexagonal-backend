package com.devpass.challengehexagonal.resources.repository

import com.devpass.challengehexagonal.domain.entity.Client
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class ClientRepository(
    @PersistenceContext
    val entityManager: EntityManager
) {

    fun getClients(): List<Client> {
        return entityManager
            .createQuery("Select c from Client c", Client::class.java)
            .resultList
    }

    fun getClientById(id: Long): Client {
        return entityManager
            .createQuery("Select c from Client c where c.id = $id", Client::class.java)
            .singleResult
    }

    @Transactional
    fun saveClient(client: Client) {
        entityManager.merge(client)
    }
}