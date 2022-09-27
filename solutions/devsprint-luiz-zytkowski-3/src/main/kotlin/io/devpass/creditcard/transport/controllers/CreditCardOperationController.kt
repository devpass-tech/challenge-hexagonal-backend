package io.devpass.creditcard.transport.controllers

import io.devpass.creditcard.domain.exceptions.OwnedException
import io.devpass.creditcard.domain.objects.CreditCardCharge
import io.devpass.creditcard.domain.objects.CreditCardOperation
import io.devpass.creditcard.domainaccess.ICreditCardOperationServiceAdapter
import io.devpass.creditcard.transport.requests.CreditCardChargeRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("creditCardOperation")
class CreditCardOperationController(
    private val creditCardOperationServiceAdapter: ICreditCardOperationServiceAdapter,
) {

    @GetMapping("/{creditCardOperationId}")
    fun getById(@PathVariable creditCardOperationId: String): CreditCardOperation {
        return creditCardOperationServiceAdapter.getById(creditCardOperationId)
            ?: throw OwnedException("Credit Card Operation Not found with ID: $creditCardOperationId")
    }

    @PutMapping
    fun rollbackOperation(@RequestBody creditCardCharge:CreditCardCharge, creditCardOperation: CreditCardOperation) : CreditCardOperation {
        return creditCardOperationServiceAdapter.rollbackOperation(creditCardCharge, creditCardOperation)
    }
}