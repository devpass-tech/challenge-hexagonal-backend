package io.devpass.creditcard.domain

import io.devpass.creditcard.data.AntiFraudGateway
import io.devpass.creditcard.data.accountmanagement.request.AccountCreationRequest
import io.devpass.creditcard.dataaccess.IAccountManagementGateway
import io.devpass.creditcard.dataaccess.ICreditCardDAO
import io.devpass.creditcard.domain.exceptions.RequestCreditCardException
import io.devpass.creditcard.domain.objects.CreditCard
import io.devpass.creditcard.domain.objects.CreditCardRequest
import io.devpass.creditcard.domainaccess.ICreditCardServiceAdapter

class CreditCardService(
    private val creditCardDAO: ICreditCardDAO,
    private val accountManagementGateway: IAccountManagementGateway,
    private val antiFraudGateway: AntiFraudGateway,
    private val accountCreationRequest: AccountCreationRequest
) : ICreditCardServiceAdapter {

    override fun findCreditCardById(creditCardId: String): CreditCard? {
        return creditCardDAO.getCreditCardById(creditCardId)
    }

    override fun requestCreditCard(creditCardRequest: CreditCardRequest){

        val eligibility = antiFraudGateway.creditCardEligibility(creditCardRequest.CPF)

        val existingCreditCardByCPF = creditCardDAO.checksExistingCreditCardByCPF(creditCardRequest.CPF)

        if (eligibility.shouldHaveCreditCard) {
            if(!existingCreditCardByCPF){
                accountManagementGateway.createAccount(accountCreationRequest = accountCreationRequest)
            } else throw RequestCreditCardException("Já existe um cartão de crédito para esse CPF")
        } else {
            throw RequestCreditCardException("Não foi possível gerar cartão de crédito")
        }
       .also { creditCardDAO.createCreditCard(CPF = creditCardRequest.CPF, creditLimit = eligibility.proposedLimit!!) }

    }
}