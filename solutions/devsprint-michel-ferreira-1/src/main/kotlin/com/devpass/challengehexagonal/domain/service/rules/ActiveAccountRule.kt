package com.devpass.challengehexagonal.domain.service.rules

import com.devpass.challengehexagonal.domain.model.Account
import com.devpass.challengehexagonal.domain.model.ValidationResult
import com.devpass.challengehexagonal.domain.model.Violation

class ActiveAccountRule {

    fun validate(account: Account): ValidationResult {
        val validationResult = ValidationResult()

        if (!account.active) {
            validationResult.violations.add(Violation.ACCOUNT_NOT_ACTIVE)
        }
        return validationResult
    }
}