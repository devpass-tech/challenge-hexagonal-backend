package io.devpass.creditcard.dataaccess


import io.devpass.creditcard.domain.objects.accountmanagement.Account
import io.devpass.creditcard.domain.objects.accountmanagement.Transaction
import io.devpass.creditcard.domain.objects.http.DefaultHttpMessage


interface IAccountManagementGateway {
    fun getByCPF(CPF: String): Account

    fun withdraw(transaction: Transaction) : DefaultHttpMessage
}
