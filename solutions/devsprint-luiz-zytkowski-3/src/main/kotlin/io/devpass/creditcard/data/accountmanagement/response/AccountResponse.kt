package io.devpass.creditcard.data.accountmanagement.response

import io.devpass.creditcard.domain.objects.accountmanagement.Account

data class AccountResponse(
    val id: String,
    val taxId: String,
    val balance: Double,
) {
    fun toAccount(): Account =
        Account(
            id = this.id,
            taxId = this.taxId,
            balance = this.balance,
        )
}
