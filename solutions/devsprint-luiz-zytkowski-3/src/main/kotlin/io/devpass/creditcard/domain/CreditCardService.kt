package io.devpass.creditcard.domain

import io.devpass.creditcard.dataaccess.IAccountManagementGateway
import io.devpass.creditcard.dataaccess.ICreditCardDAO
import io.devpass.creditcard.domainaccess.ICreditCardServiceAdapter

class CreditCardService(
    creditCardDAO: ICreditCardDAO,
    accountManagementGateway: IAccountManagementGateway,
) : ICreditCardServiceAdapter {


}