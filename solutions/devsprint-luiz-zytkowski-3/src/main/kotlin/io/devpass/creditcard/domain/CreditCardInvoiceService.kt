package io.devpass.creditcard.domain

import io.devpass.creditcard.dataaccess.ICreditCardInvoiceDAO
import io.devpass.creditcard.domain.exceptions.BusinessRuleException
import io.devpass.creditcard.domain.objects.CreditCardInvoice
import io.devpass.creditcard.domainaccess.ICreditCardInvoiceServiceAdapter
import javax.persistence.EntityNotFoundException

class CreditCardInvoiceService (
    private val creditCardInvoiceDAO: ICreditCardInvoiceDAO,
) : ICreditCardInvoiceServiceAdapter {
    override fun getById(creditCardInvoiceId: String): CreditCardInvoice? {
        return creditCardInvoiceDAO.getById(creditCardInvoiceId)
    }

    override fun generateCreditCardInvoice(
        creditCardId: String,
        invoiceMonth: Int,
        invoiceYear: Int
    ): CreditCardInvoice {
        creditCardInvoiceDAO.getById(creditCardId)
            ?: throw EntityNotFoundException("Cartão de id: $creditCardId não encontrado")

        if (invoiceMonth !in 1..12) {
            throw BusinessRuleException("Mês inserido inválido")
        }

        if (invoiceYear < 1950) {
            throw BusinessRuleException("Ano inserido inválido")
        }

        return creditCardInvoiceDAO.generateCreditCardInvoice(creditCardId, invoiceMonth, invoiceYear)
    }
}