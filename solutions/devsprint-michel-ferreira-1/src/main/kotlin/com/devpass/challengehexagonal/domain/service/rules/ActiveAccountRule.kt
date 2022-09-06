package com.devpass.challengehexagonal.domain.service.rules

import com.devpass.challengehexagonal.domain.model.Account
import com.devpass.challengehexagonal.domain.model.ValidationResult
import com.devpass.challengehexagonal.domain.model.Violation
import com.devpass.challengehexagonal.domain.ports.AccountRepositoryPort

class ActiveAccountRule(
    private val accountRepositoryPort: AccountRepositoryPort
) {

    fun validate(account: Account): ValidationResult {
        val validationResult = ValidationResult()
        val account = accountRepositoryPort.getAccount(accountId = account.id!!)

        if (account.active) {
            validationResult.violations.add(Violation.ACCOUNT_NOT_ACTIVE)
        }
        return validationResult
    }
}