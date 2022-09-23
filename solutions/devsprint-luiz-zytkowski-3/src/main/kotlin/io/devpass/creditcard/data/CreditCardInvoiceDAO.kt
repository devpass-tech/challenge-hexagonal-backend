package io.devpass.creditcard.data


import io.devpass.creditcard.data.repositories.CreditCardInvoiceRepository
import io.devpass.creditcard.dataaccess.ICreditCardInvoiceDAO
import io.devpass.creditcard.domain.exceptions.OwnedException
import io.devpass.creditcard.domain.objects.CreditCardInvoice
import io.devpass.creditcard.domain.objects.CreditCardInvoiceByDate
import io.devpass.creditcard.domain.objects.CreditCardOperation

class CreditCardInvoiceDAO(
    private val creditCardInvoiceRepository: CreditCardInvoiceRepository,
) : ICreditCardInvoiceDAO {
    override fun getById(id: String): CreditCardInvoice? {
        val creditCardInvoiceEntity = creditCardInvoiceRepository.findById(id)
        return if (creditCardInvoiceEntity.isPresent) creditCardInvoiceEntity.get()
            .toCreditCardInvoice() else null
    }

//    wip
//    override fun findInvoiceByDate(creditCardInvoiceByDate: CreditCardInvoiceByDate): List<CreditCardInvoice?> {
//        val creditCardInvoiceEntity = creditCardInvoiceRepository.findByInvoiceByDate(creditCardInvoiceByDate)
//        return if (creditCardInvoiceEntity.isPresent) creditCardInvoiceEntity.get()
//             else throw OwnedException("Not found")
//    }

}