package io.devpass.creditcard.domain

import io.devpass.creditcard.dataaccess.ICreditCardDAO
import io.devpass.creditcard.domainaccess.ICreditCardServiceAdapter

class CreditCardService(
    creditCardDAO: ICreditCardDAO,
) : ICreditCardServiceAdapter {


}