package com.devpass.challengehexagonal.resources.repository

import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
interface TransactionRepository {
    val entityManager: EntityManager
}