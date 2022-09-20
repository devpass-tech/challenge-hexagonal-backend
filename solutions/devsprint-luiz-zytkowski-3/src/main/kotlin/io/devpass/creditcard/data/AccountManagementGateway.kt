package io.devpass.creditcard.data

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.isSuccessful
import com.github.kittinunf.fuel.jackson.jacksonDeserializerOf
import io.devpass.creditcard.dataaccess.IAccountManagementGateway
import io.devpass.creditcard.domain.objects.AccountManagement
import java.lang.RuntimeException

class AccountManagementGateway : IAccountManagementGateway {
    override fun getByCPF(CPF: String): AccountManagement {
        val (_, result, response) = Fuel
            .get("http://localhost:7445/account-management/balance-by-tax-id/{taxId}")
            .responseObject<AccountManagement>(jacksonDeserializerOf())
        return if (result.isSuccessful) {
            response.get()
        } else {
            throw RuntimeException("Erro na busca da conta pelo CPF: $CPF")
        }
    }
}