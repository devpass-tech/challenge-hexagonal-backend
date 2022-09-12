package com.devpass.challengehexagonal.application.DTO

import com.devpass.challengehexagonal.domain.model.Client
import java.math.BigDecimal

data class ClientResponseDTO(
    val name: String,
    val balance: BigDecimal,
) {
    constructor(client: Client) : this(
        name = client.name,
        balance = client.account.balance.toBigDecimal()
    )
}