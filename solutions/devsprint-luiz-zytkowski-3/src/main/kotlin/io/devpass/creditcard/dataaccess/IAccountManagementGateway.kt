package io.devpass.creditcard.dataaccess

import io.devpass.creditcard.data.accountmanagement.response.requests.AccountCreationRequest
import io.devpass.creditcard.domain.objects.accountmanagement.Account

interface IAccountManagementGateway {
    fun getByCPF(CPF: String): Account

    fun createAccount(accountCreationRequest: AccountCreationRequest) : Account
}
