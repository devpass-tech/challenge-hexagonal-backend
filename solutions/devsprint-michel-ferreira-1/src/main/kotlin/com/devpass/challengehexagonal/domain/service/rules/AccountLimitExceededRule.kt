package com.devpass.challengehexagonal.domain.service.rules

import com.devpass.challengehexagonal.domain.model.Account
import com.devpass.challengehexagonal.domain.model.Transaction
import com.devpass.challengehexagonal.domain.model.ValidationResult
import com.devpass.challengehexagonal.domain.model.Violation

class AccountLimitExceededRule {
    fun validate(account: Account, transaction: Transaction): ValidationResult {
        val validationResult = ValidationResult()
        if (transaction.value > account.balance.toBigDecimal()) {
            validationResult.violations.add(Violation.LIMIT_EXCEEDED)
        }
        return validationResult
    }
}