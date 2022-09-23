package io.devpass.creditcard.data.repositories

import io.devpass.creditcard.data.entities.CreditCardInvoiceEntity
import io.devpass.creditcard.domain.objects.CreditCardInvoice
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CreditCardInvoiceRepository : CrudRepository<CreditCardInvoiceEntity, String> {

    @Query("select cci from CreditCardInvoice cci where cci.credit_card = ?1 and cci.month = ?2 and cci.year = ?3")
    fun findByInvoiceByDate(creditCard: String, month: Int, year: Int): CreditCardInvoice?
}