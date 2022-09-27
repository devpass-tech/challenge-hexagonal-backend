package io.devpass.creditcard.data

import io.devpass.creditcard.data.entities.CreditCardEntity
import io.devpass.creditcard.data.repositories.CreditCardRepository
import io.devpass.creditcard.dataaccess.ICreditCardDAO
import io.devpass.creditcard.domain.exceptions.EntityNotFoundException
import io.devpass.creditcard.domain.objects.CreditCard
import java.time.LocalDateTime
import java.util.UUID

class CreditCardDAO(
   private val creditCardRepository: CreditCardRepository,
) : ICreditCardDAO {
    override fun getCreditCardById(id: String): CreditCard? {
        val creditCard = creditCardRepository.findById(id)
        return if (creditCard.isPresent) creditCard.get().toCreditCard() else null
    }

    override fun checksExistingCreditCardByCPF(CPF: String): CreditCard? {
        return creditCardRepository.searchCreditCardEntityByOwner(CPF).firstOrNull()?.toCreditCard()
    }

    override fun createCreditCard(creditCard: CreditCard) : CreditCard {

        return creditCardRepository.save(CreditCardEntity(
            id = UUID.randomUUID().toString(),
            owner = creditCard.owner,
            number = creditCard.number,
            securityCode = creditCard.securityCode,
            printedName = creditCard.printedName,
            creditLimit = creditCard.creditLimit,
            availableCreditLimit = creditCard.availableCreditLimit,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now(),
        )).toCreditCard()
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