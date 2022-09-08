package com.devpass.challengehexagonal.domain.service.rules

import com.devpass.challengehexagonal.domain.model.Account
import com.devpass.challengehexagonal.domain.model.Transaction
import com.devpass.challengehexagonal.domain.model.ValidationResult
import com.devpass.challengehexagonal.domain.model.Violation
import com.devpass.challengehexagonal.domain.ports.TransactionRepositoryPort
import org.springframework.stereotype.Service

@Service
class HighFrequencyTransactionRule(
    private val transactionRepositoryPort: TransactionRepositoryPort
) {

    fun validate(account: Account, transaction: Transaction): ValidationResult {
        val validationResult = ValidationResult()
        val limitDateToHighFrequency = transaction.transactionDate.minusHours(1)
        val transactions: List<Transaction> = transactionRepositoryPort
            .getTransactionByDateRange(
                account.id!!,
                transaction.establishment,
                limitDateToHighFrequency,
                transaction.transactionDate
            )

        if (transactions.size >= 3) {
            validationResult.violations.add(Violation.HIGH_FREQUENCY_TRANSACTION)
        }

        return validationResult
    }
}

class HighTransaction(
    private val transactionRepositoryPort: TransactionRepositoryPort
) {
    fun validate(account: Account, transaction: Transaction): ValidationResult {
        val validationResult = ValidationResult()
        val transactions = transactionRepositoryPort.getTransactionByDateTime(account.id!!, transaction.transactionDate)
        if (transactions.isEmpty()) {
            if ((account.balance.toBigDecimal().multiply(0.80.toBigDecimal())) < transaction.value) {
                validationResult.violations.add(Violation.HIGH_FREQUENCY_TRANSACTION)
            }
        }
        return validationResult
    }
}