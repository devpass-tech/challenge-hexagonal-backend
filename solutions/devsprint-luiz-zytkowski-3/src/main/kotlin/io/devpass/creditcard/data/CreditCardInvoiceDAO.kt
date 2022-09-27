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

    override fun generateCreditCardInvoice(creditCardInvoice : CreditCardInvoice): CreditCardInvoice {
        return creditCardInvoiceRepository.save(
            CreditCardInvoiceEntity(
                id = UUID.randomUUID().toString(),
                creditCard = creditCardInvoice.creditCard,
                month = creditCardInvoice.month,
                year = creditCardInvoice.year,
                value = creditCardInvoice.value,
                createdAt = LocalDateTime.now(),
                paidAt = null
            )
        ).toCreditCardInvoice()
    }
}