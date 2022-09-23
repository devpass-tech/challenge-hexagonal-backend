package io.devpass.creditcard.transport.controllers

import io.devpass.creditcard.domain.exceptions.OwnedException
import io.devpass.creditcard.domain.objects.CreditCardOperation
import io.devpass.creditcard.domainaccess.ICreditCardOperationServiceAdapter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("credit-card-operation")
class CreditCardOperationController(
    private val creditCardOperationServiceAdapter: ICreditCardOperationServiceAdapter,
) {

    @GetMapping("/{creditCardOperationId}")
    fun getById(@PathVariable creditCardOperationId: String): CreditCardOperation {
        return creditCardOperationServiceAdapter.getById(creditCardOperationId)
            ?: throw OwnedException("Credit Card Operation Not found with ID: $creditCardOperationId")
    }

    @GetMapping("/")
    fun operationReport(
        @RequestBody creditCardId: String,
        operationMonth: Int,
        operationYear: Int
    ): List<CreditCardOperation?> {
        val creditCardOperation = creditCardOperationServiceAdapter.operationReport(creditCardId, operationMonth, operationYear)
        return creditCardOperation.ifEmpty {
            throw OwnedException("Bank statement empty for: $operationMonth/$operationYear")
        }
    }
}