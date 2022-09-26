package io.devpass.creditcard.dataaccess

import io.devpass.creditcard.domain.objects.CreditCardInvoice

interface ICreditCardInvoiceDAO {
    fun getById(id: String): CreditCardInvoice?

    fun generateCreditCardInvoice(creditCardId: String, invoiceMonth: Int, invoiceYear: Int) : CreditCardInvoice
}