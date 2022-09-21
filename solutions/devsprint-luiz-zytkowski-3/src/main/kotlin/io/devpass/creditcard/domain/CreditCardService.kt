package io.devpass.creditcard.domain

import io.devpass.creditcard.dataaccess.IAccountManagementGateway
import io.devpass.creditcard.dataaccess.ICreditCardDAO
import io.devpass.creditcard.domain.objects.CreditCard
import io.devpass.creditcard.domainaccess.ICreditCardServiceAdapter

class CreditCardService(
    private val creditCardDAO: ICreditCardDAO,
    private val accountManagementGateway: IAccountManagementGateway,
) : ICreditCardServiceAdapter {

    override fun findCreditCardById(creditCardId: String): CreditCard? {
        return creditCardDAO.getCreditCardById(creditCardId)
    }

}