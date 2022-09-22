package io.devpass.creditcard.transport.controllers

import io.devpass.creditcard.domain.exceptions.OwnedException
import io.devpass.creditcard.domain.objects.CreditCard
import io.devpass.creditcard.domainaccess.ICreditCardServiceAdapter
import io.devpass.creditcard.transport.requests.CreditCardChargeResquest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("credit-cards")
class CreditCardController(
    private val creditCardServiceAdapter: ICreditCardServiceAdapter,
) {

    @GetMapping("/{creditCardId}")
    fun findCreditCard(@PathVariable creditCardId: String): CreditCard {
        return creditCardServiceAdapter.findCreditCardById(creditCardId)
            ?: throw OwnedException("CreditCard Not found with number: $creditCardId")
    }

    @PostMapping
    fun chargeCreditCard(@RequestBody creditCardChargeResquest: CreditCardChargeResquest) {
        creditCardServiceAdapter.chargeCreditCard(creditCardChargeResquest.toCreditCardCharge())
    }
}