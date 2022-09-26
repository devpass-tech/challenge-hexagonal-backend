package io.devpass.creditcard.domain

import io.devpass.creditcard.data.AntiFraudGateway
import io.devpass.creditcard.dataaccess.IAccountManagementGateway
import io.devpass.creditcard.dataaccess.ICreditCardDAO
import io.devpass.creditcard.domain.creditcard.CreditCardNumberGenerator
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

        if (!eligibility.shouldHaveCreditCard)
            throw RequestCreditCardException("Não foi possível gerar cartão de crédito")

        val proposedLimit = eligibility.proposedLimit
            ?: throw RuntimeException("Deu muito ruim")


        creditCardDAO.checksExistingCreditCardByCPF(creditCardRequest.CPF)?.also {
            throw RequestCreditCardException("Já existe cartão de crédito para esse CPF")
        }


        val creditCard = CreditCard(
            id = "",
            owner = creditCardRequest.CPF,
            number = CreditCardNumberGenerator.generateCreditCardNumber(bin = "1234", length = 11),
            securityCode = CreditCardNumberGenerator.generateCreditCardSecurityNumber(length = 3),
            printedName = creditCardRequest.name,
            creditLimit = proposedLimit,
            availableCreditLimit = proposedLimit,
        )

        accountManagementGateway.createAccount(cpf = creditCardRequest.CPF)

        return creditCardDAO.createCreditCard(creditCard)
    }
}