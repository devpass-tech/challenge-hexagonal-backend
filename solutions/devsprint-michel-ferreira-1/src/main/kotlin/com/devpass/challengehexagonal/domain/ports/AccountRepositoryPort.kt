package com.devpass.challengehexagonal.domain.ports

import com.devpass.challengehexagonal.domain.model.Account

interface AccountRepositoryPort {

    fun getAccount(
        accountId: Long,
    ): Account
}