package io.devpass.creditcard.data.responses

import io.devpass.creditcard.domain.objects.AccountManagement

data class AccountManagementResponse(
    var taxId: String,
) {
    fun toAccountManagement(): AccountManagement =
        AccountManagement(
            taxId = this.taxId
        )
}
