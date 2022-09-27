package io.devpass.creditcard.transport.controllers

import io.devpass.creditcard.domain.exceptions.OwnedException
import io.devpass.creditcard.domain.objects.CreditCardInvoice
import io.devpass.creditcard.transport.requests.CreditCardInvoiceByDateRequest
import io.devpass.creditcard.domainaccess.ICreditCardInvoiceServiceAdapter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("credit-card-invoices")
class CreditCardInvoiceController(
    private val creditCardInvoiceServiceAdapter: ICreditCardInvoiceServiceAdapter
) {
    @GetMapping("/{creditCardInvoiceId}")
    fun getById(@PathVariable creditCardInvoiceId: String): CreditCardInvoice {
        return creditCardInvoiceServiceAdapter.getById(creditCardInvoiceId)
            ?: throw OwnedException("Credit Card Invoice Not found with ID: $creditCardInvoiceId")
    }

    @GetMapping("/by-date")
    fun findInvoiceByDate(
        @RequestParam creditCard: String,
        @RequestParam month: Int,
        @RequestParam year: Int
    ): CreditCardInvoice? {
        val creditCardInvoiceByDateRequest = CreditCardInvoiceByDateRequest(
            creditCard = creditCard, month = month, year = year
        )
        return creditCardInvoiceServiceAdapter.findInvoiceByDate(creditCardInvoiceByDateRequest.toCreditCardInvoiceByDate())
            ?: throw OwnedException("Credit Card Invoices Not found")
    }
}