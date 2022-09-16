package io.devpass.creditcard.data

import io.devpass.creditcard.data.repositories.CreditCardRepository
import io.devpass.creditcard.dataaccess.ICreditCardDAO
import io.devpass.creditcard.domain.objects.CreditCard

class CreditCardDAO : ICreditCardDAO {
    override fun getCrecitCardById(id: Int): CreditCard {
        TODO("Not yet implemented")
    }
}