package io.devpass.creditcard.dataaccess
import io.devpass.creditcard.domain.objects.accountmanagement.Account

interface IAccountManagementGateway {
    fun getByCPF(CPF: String): Account

    fun getAccountById(accountId : String) : Account
}
