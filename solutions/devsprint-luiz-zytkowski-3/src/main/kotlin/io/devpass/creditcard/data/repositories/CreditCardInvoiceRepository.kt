package io.devpass.creditcard.data.repositories

import io.devpass.creditcard.data.entities.CreditCardInvoiceEntity
import io.devpass.creditcard.domain.objects.CreditCardInvoice
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CreditCardInvoiceRepository : CrudRepository<CreditCardInvoiceEntity, String> {

    @Query("select ccie from CreditCardInvoiceEntity ccie where ccie.credit_card = ?1 and ccie.month = ?2 and ccie.year = ?3")
    fun findByInvoiceByDate(creditCard: String, month: Int, year: Int): List<CreditCardInvoiceEntity>
}