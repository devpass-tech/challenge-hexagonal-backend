package com.devpass.challengehexagonal.domain.service

import com.devpass.challengehexagonal.domain.exceptions.ViolationException
import com.devpass.challengehexagonal.domain.model.Transaction
import com.devpass.challengehexagonal.domain.model.Violation
import com.devpass.challengehexagonal.domain.ports.ClientRepositoryPort
import com.devpass.challengehexagonal.domain.ports.LocationPort
import com.devpass.challengehexagonal.domain.service.rules.AccountLimitExceededRule
import com.devpass.challengehexagonal.domain.service.rules.ActiveAccountRule
import com.devpass.challengehexagonal.domain.service.rules.HighFrequencyTransactionRule

class TransactionService(
    private val clientRepositoryPort: ClientRepositoryPort,
    private val locationPort: LocationPort,
    private val activeAccountRule: ActiveAccountRule,
    private val highFrequencyTransactionRule: HighFrequencyTransactionRule,
    private val accountLimitExceededRule: AccountLimitExceededRule,
    private val highTransactionRule: HighTransactionRule,
    private val duplicationTransactionRule: DuplicationTransactionRule
) {
   fun processTransaction(clientId: Long, transaction: Transaction, zipCode: String) {
        val client = clientRepositoryPort.getById(clientId) ?: throw Exception()
        val violations = mutableListOf<Violation>()

        val activeAccountValidation = activeAccountRule.validate(client.account)
        violations.addAll(activeAccountValidation.violations)

        val highFrequencyTransactionValidation = highFrequencyTransactionRule.validate(client.account, transaction)
        violations.addAll(highFrequencyTransactionValidation.violations)

       val accountLimitExceededRuleValidation = accountLimitExceededRule.validate(client.account, transaction)
       violations.addAll(highFrequencyTransactionValidation.violations)

       val highTransactionRuleValidation = highTransactionRule.validate(client.account, transaction)
       violations.addAll(highFrequencyTransactionValidation.violations)

       val duplicationTransactionRuleValidation = duplicationTransactionRule.validate(client.account, transaction)
       violations.addAll(highFrequencyTransactionValidation.violations)

       if (violations == null){
          val location = locationPort.getLocationByZipCode(zipCode)
           transaction.location = location
       } else {
           return ViolationException(violations)
       }
    }
}