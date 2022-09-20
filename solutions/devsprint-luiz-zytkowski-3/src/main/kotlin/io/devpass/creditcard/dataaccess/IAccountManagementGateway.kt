package io.devpass.creditcard.dataaccess

import io.devpass.creditcard.domain.objects.AccountManagement

interface IAccountManagementGateway {
    fun getByCPF(CPF: String): AccountManagement
}