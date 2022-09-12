package com.devpass.challengehexagonal.resources.repository.entity

import com.devpass.challengehexagonal.domain.model.Account
import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "account")
data class AccountEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val accountNumber: Long,

    var balance: BigDecimal,
) {
    fun toDomain() = Account(accountNumber = this.accountNumber, balance = this.balance.toDouble(), active = true)
}
