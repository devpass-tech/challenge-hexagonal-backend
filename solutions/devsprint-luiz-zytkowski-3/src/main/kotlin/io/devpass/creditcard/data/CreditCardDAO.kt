package io.devpass.creditcard.data

import io.devpass.creditcard.data.repositories.CreditCardRepository
import io.devpass.creditcard.dataaccess.ICreditCardDAO
import io.devpass.creditcard.domain.objects.CreditCard

class CreditCardDAO(
   private val creditCardRepository: CreditCardRepository
) : ICreditCardDAO {
    override fun getCreditCardById(id: String): CreditCard? {
        val creditCard = creditCardRepository.findById(id)
        return if(creditCard.isPresent) creditCard.get().toCreditCard() else null
    }
}