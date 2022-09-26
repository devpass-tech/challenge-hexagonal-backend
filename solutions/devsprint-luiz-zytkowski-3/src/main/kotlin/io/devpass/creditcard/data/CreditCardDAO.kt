package io.devpass.creditcard.data

import io.devpass.creditcard.data.entities.CreditCardEntity
import io.devpass.creditcard.data.repositories.CreditCardRepository
import io.devpass.creditcard.dataaccess.ICreditCardDAO
import io.devpass.creditcard.domain.objects.CreditCard
import javax.persistence.EntityNotFoundException

class CreditCardDAO(
   private val creditCardRepository: CreditCardRepository
) : ICreditCardDAO {
    override fun getCreditCardById(id: String): CreditCard? {
        val creditCard = creditCardRepository.findById(id)
        return if(creditCard.isPresent) creditCard.get().toCreditCard() else null
    }

    override fun updateAvailableCreditLimit(creditCard: CreditCard): CreditCard {
        val savedCreditCard = getCreditCardById(creditCard.id)
                ?: throw EntityNotFoundException("not found - Invalid CreditCardId to update")

        return creditCardRepository.save(
                CreditCardEntity(
                        id = savedCreditCard.id,
                        owner = savedCreditCard.owner,
                        number = savedCreditCard.number,
                        securityCode = savedCreditCard.securityCode,
                        printedName = savedCreditCard.printedName,
                        creditLimit = savedCreditCard.creditLimit,
                        availableCreditLimit = creditCard.availableCreditLimit,
                )
        ).toCreditCard()
    }
}