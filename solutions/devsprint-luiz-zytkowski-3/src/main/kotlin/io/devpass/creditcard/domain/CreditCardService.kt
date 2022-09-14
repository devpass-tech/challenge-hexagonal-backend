package io.devpass.creditcard.domain

import io.devpass.creditcard.dataaccess.ICreditCardRepository
import io.devpass.creditcard.domainaccess.ICreditCardServiceAdapter

class CreditCardService(
    creditCardRepository: ICreditCardRepository,
) : ICreditCardServiceAdapter {


}