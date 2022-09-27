package io.devpass.creditcard.dataaccess

import io.devpass.creditcard.domain.objects.CreditCardInvoice
import io.devpass.creditcard.domain.objects.CreditCardInvoiceByDate

interface ICreditCardInvoiceDAO {
    fun getById(id: String): CreditCardInvoice?

    fun findInvoiceByDate(creditCardInvoiceByDate: CreditCardInvoiceByDate): CreditCardInvoice?

    fun generateCreditCardInvoice(creditCardId: String) : CreditCardInvoice
}