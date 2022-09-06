package com.devpass.challengehexagonal.domain.service

import com.devpass.challengehexagonal.domain.model.Client

interface ClientManagerServicePort {

    fun getClient(clientId: Long) : Client
}
