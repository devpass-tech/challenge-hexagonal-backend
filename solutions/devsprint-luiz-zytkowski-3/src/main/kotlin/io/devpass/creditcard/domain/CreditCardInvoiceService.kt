package io.devpass.creditcard.domain

import io.devpass.creditcard.dataaccess.ICreditCardDAO
import io.devpass.creditcard.dataaccess.ICreditCardInvoiceDAO
import io.devpass.creditcard.dataaccess.ICreditCardOperationDAO
import io.devpass.creditcard.domain.exceptions.OwnedException
import io.devpass.creditcard.domain.objects.CreditCardInvoice
import io.devpass.creditcard.domain.objects.CreditCardInvoiceByDate
import io.devpass.creditcard.domainaccess.ICreditCardInvoiceServiceAdapter
import javax.persistence.EntityNotFoundException
import java.time.LocalDateTime

class CreditCardInvoiceService(
    private val creditCardDAO: ICreditCardDAO,
    private val creditCardInvoiceDAO: ICreditCardInvoiceDAO,
    private val creditCardOperationDAO: ICreditCardOperationDAO,
) : ICreditCardInvoiceServiceAdapter {
    override fun getById(creditCardInvoiceId: String): CreditCardInvoice? {
        return creditCardInvoiceDAO.getById(creditCardInvoiceId)
    }

    override fun findInvoiceByDate(creditCardInvoiceByDate: CreditCardInvoiceByDate): CreditCardInvoice? {
        val creditCard = creditCardInvoiceDAO.getById(creditCardInvoiceByDate.creditCard)
            ?: throw OwnedException("Cartão de ID: ${creditCardInvoiceByDate.creditCard} não encontrado.")

        if (creditCardInvoiceByDate.month !in 1..12) {
            throw OwnedException("Mês inserido inválido")
        }

        if (creditCardInvoiceByDate.year < 1950 && creditCardInvoiceByDate.year > LocalDateTime.now().year) {
            throw OwnedException("Ano inserido inválido")
        }

        return creditCardInvoiceDAO.findInvoiceByDate(creditCardInvoiceByDate)
    }

    override fun generateCreditCardInvoice(
        creditCardId: String,
    ): CreditCardInvoice {
        creditCardDAO.getCreditCardById(creditCardId)
            ?: throw EntityNotFoundException("Cartão de id: $creditCardId não encontrado")

        val listOfCreditCardOperation =
            creditCardOperationDAO.operationReport(
                creditCardId,
                LocalDateTime.now().monthValue,
                LocalDateTime.now().year
            ).filter {
                it.type == "Cobrança" || it.type == "Estorno"
            }

        val invoiceValue = listOfCreditCardOperation.sumOf {
            it.value
        }

        val creditCardInvoice = CreditCardInvoice(
            id = "", // will be auto-generated
            creditCard = creditCardId,
            month = LocalDateTime.now().monthValue,
            year = LocalDateTime.now().year,
            value = invoiceValue,
            createdAt = LocalDateTime.now(),
            paidAt = null,
        )

        return creditCardInvoiceDAO.generateCreditCardInvoice(creditCardInvoice)
    }
}