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
) : ICreditCardServiceAdapter {

    override fun findCreditCardById(creditCardId: String): CreditCard? {
        return creditCardDAO.getCreditCardById(creditCardId)
    }

    override fun requestCreditCard(creditCardRequest: CreditCardRequest): CreditCard {

        val eligibility = antiFraudGateway.creditCardEligibility(creditCardRequest.CPF)

        if (eligibility.shouldHaveCreditCard)
            throw RequestCreditCardException("Não foi possível gerar cartão de crédito")

        val proposedLimit = eligibility.proposedLimit
            ?: throw RuntimeException("Deu muito ruim")


        creditCardDAO.checksExistingCreditCardByCPF(creditCardRequest.CPF)?.also {
            throw RequestCreditCardException("Já existe cartão de crédito para esse CPF")
        }


        accountManagementGateway.createAccount(cpf = creditCardRequest.CPF)

        return creditCardDAO.createCreditCard(CPF = creditCardRequest.CPF, name = creditCardRequest.name, creditLimit = proposedLimit)
    }
}