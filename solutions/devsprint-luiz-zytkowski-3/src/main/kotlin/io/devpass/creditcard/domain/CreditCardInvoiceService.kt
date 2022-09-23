package io.devpass.creditcard.domain

import io.devpass.creditcard.dataaccess.ICreditCardInvoiceDAO
import io.devpass.creditcard.domain.exceptions.OwnedException
import io.devpass.creditcard.domain.objects.CreditCardInvoice
import io.devpass.creditcard.domain.objects.CreditCardInvoiceByDate
import io.devpass.creditcard.domainaccess.ICreditCardInvoiceServiceAdapter

class CreditCardInvoiceService(
    private val creditCardInvoiceDAO: ICreditCardInvoiceDAO
) : ICreditCardInvoiceServiceAdapter {
    override fun getById(creditCardInvoiceId: String): CreditCardInvoice? {
        return creditCardInvoiceDAO.getById(creditCardInvoiceId)
    }

    override fun findInvoiceByDate(creditCardInvoiceByDate: CreditCardInvoiceByDate): List<CreditCardInvoice?> {
        val creditCard = creditCardInvoiceDAO.getById(creditCardInvoiceByDate.creditCard)
            ?: throw OwnedException("Cartão de ID: ${creditCardInvoiceByDate.creditCard} não encontrado.")

        if (creditCardInvoiceByDate.month in 1..12) {
            throw OwnedException("Mês inserido inválido")
        }

        if (creditCardInvoiceByDate.year > 1950 && creditCard.year < 2022) {
            throw OwnedException("Ano inserido inválido")
        }

        return creditCardInvoiceDAO.findInvoiceByDate(creditCardInvoiceByDate)
    }
}