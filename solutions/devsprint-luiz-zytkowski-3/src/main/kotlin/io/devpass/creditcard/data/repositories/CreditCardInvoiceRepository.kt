package io.devpass.creditcard.data.repositories

import io.devpass.creditcard.data.entities.CreditCardInvoiceEntity
import io.devpass.creditcard.domain.objects.CreditCardInvoice
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CreditCardInvoiceRepository : CrudRepository<CreditCardInvoiceEntity, String> {

//    WIP
//    @Query()
//    fun findByInvoiceByDate(): List<CreditCardInvoice?>
}