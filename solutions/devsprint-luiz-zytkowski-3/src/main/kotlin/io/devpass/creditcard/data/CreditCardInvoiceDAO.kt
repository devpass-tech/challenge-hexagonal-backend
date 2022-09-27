package io.devpass.creditcard.data


import io.devpass.creditcard.data.entities.CreditCardInvoiceEntity
import io.devpass.creditcard.data.repositories.CreditCardInvoiceRepository
import io.devpass.creditcard.data.repositories.CreditCardOperationRepository
import io.devpass.creditcard.dataaccess.ICreditCardInvoiceDAO
import io.devpass.creditcard.domain.objects.CreditCardInvoice
import io.devpass.creditcard.domain.objects.CreditCardInvoiceByDate
import java.time.LocalDateTime
import java.util.UUID

class CreditCardInvoiceDAO(
    private val creditCardInvoiceRepository: CreditCardInvoiceRepository,
    private val creditCardOperationRepository: CreditCardOperationRepository
) : ICreditCardInvoiceDAO {
    override fun getById(id: String): CreditCardInvoice? {
        val creditCardInvoiceEntity = creditCardInvoiceRepository.findById(id)
        return if (creditCardInvoiceEntity.isPresent) creditCardInvoiceEntity.get()
            .toCreditCardInvoice() else null
    }

    override fun findInvoiceByDate(creditCardInvoiceByDate: CreditCardInvoiceByDate): CreditCardInvoice? {
        return creditCardInvoiceRepository.findByInvoiceByDate(
            creditCardInvoiceByDate.creditCard,
            creditCardInvoiceByDate.month,
            creditCardInvoiceByDate.year
        ).firstOrNull()?.toCreditCardInvoice()

    }

    override fun generateCreditCardInvoice(creditCardId: String): CreditCardInvoice {
        val listOfCreditCardOperation =
            creditCardOperationRepository.listByPeriod(
                creditCardId,
                LocalDateTime.now().monthValue,
                LocalDateTime.now().year
            ).filter {
                it.type == "Cobrança" || it.type == "Estorno"
            }.map { it.toCreditCardOperation() }

        val invoiceValue = listOfCreditCardOperation.sumOf {
            it.value
        }

        return creditCardInvoiceRepository.save<CreditCardInvoiceEntity?>(
            CreditCardInvoiceEntity(
                id = UUID.randomUUID().toString(),
                creditCard = creditCardId,
                month = LocalDateTime.now().monthValue,
                year = LocalDateTime.now().year,
                value = invoiceValue,
                createdAt = LocalDateTime.now(),
                paidAt = null
            )
        ).toCreditCardInvoice()
    }
}