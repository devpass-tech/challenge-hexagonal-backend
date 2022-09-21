package io.devpass.creditcard.data.accountmanagement.response.requests

data class AccountCreationRequest(
        val taxId: String,
        val balance: Double,
)