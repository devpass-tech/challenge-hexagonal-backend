package io.devpass.creditcard.data

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.isSuccessful
import com.github.kittinunf.fuel.jackson.jacksonDeserializerOf
import io.devpass.creditcard.data.accountmanagement.response.AccountResponse
import io.devpass.creditcard.dataaccess.IAccountManagementGateway
import io.devpass.creditcard.domain.exceptions.GatewayException
import io.devpass.creditcard.domain.objects.accountmanagement.Account

class AccountManagementGateway(
    private val baseUrl: String,
) : IAccountManagementGateway {

    override fun getByCPF(CPF: String): Account {
        val (_, result, response) = Fuel
            .get("$baseUrl/account-management/balance-by-tax-id/$CPF")
            .responseObject<AccountResponse>(jacksonDeserializerOf())
        return if (result.isSuccessful) {
            response.get().toAccount()
        } else {
            throw GatewayException("Erro na busca da conta pelo CPF: $CPF")
        }
    }
    override fun getAccountById(accountId: String) : Account {
        val (_, result, response) = Fuel
                .get("$baseUrl/account-management/balance/$accountId")
                .responseObject<AccountResponse>(jacksonDeserializerOf())
        return if (result.isSuccessful) {
            response.get().toAccount()
        } else {
            throw GatewayException("Erro na busca da conta pelo ID: $accountId")
        }
    }
}