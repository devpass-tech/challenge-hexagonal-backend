package io.devpass.creditcard.data

import io.devpass.creditcard.data.entities.CreditCardEntity
import io.devpass.creditcard.data.repositories.CreditCardRepository
import io.devpass.creditcard.dataaccess.ICreditCardDAO
import io.devpass.creditcard.domain.objects.CreditCard

class CreditCardDAO(
   private val creditCardRepository: CreditCardRepository,
   private val creditCard: CreditCardEntity,
) : ICreditCardDAO {
    override fun getCreditCardById(id: String): CreditCard? {
        val creditCard = creditCardRepository.findById(id)
        return if(creditCard.isPresent) creditCard.get().toCreditCard() else null
    }

    override fun checksExistingCreditCardByCPF(CPF: String): CreditCard? {
        return creditCardRepository.searchCreditCardEntityByOwner(CPF).firstOrNull()?.toCreditCard()
    }

    override fun createCreditCard(CPF: String, creditLimit: Double) : CreditCard {
        return creditCardRepository.save(creditCard).toCreditCard()
    }
}