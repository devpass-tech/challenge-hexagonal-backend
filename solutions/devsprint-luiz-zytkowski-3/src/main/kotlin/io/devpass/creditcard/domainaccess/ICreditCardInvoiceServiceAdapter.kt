package io.devpass.creditcard.domainaccess

import io.devpass.creditcard.domain.objects.CreditCardInvoice
import io.devpass.creditcard.domain.objects.CreditCardInvoiceByDate

interface ICreditCardInvoiceServiceAdapter {
    fun getById(creditCardInvoiceId: String): CreditCardInvoice?

    fun findInvoiceByDate(creditCardInvoiceByDate: CreditCardInvoiceByDate): CreditCardInvoice?
}