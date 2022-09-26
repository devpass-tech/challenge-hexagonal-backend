package io.devpass.creditcard.domain

import io.devpass.creditcard.dataaccess.ICreditCardDAO
import io.devpass.creditcard.dataaccess.ICreditCardOperationDAO
import io.devpass.creditcard.domain.objects.CreditCardCharge
import io.devpass.creditcard.domain.objects.CreditCardOperation
import io.devpass.creditcard.domainaccess.ICreditCardOperationServiceAdapter
import javax.persistence.EntityNotFoundException

class CreditCardOperationService(
        private val creditCardOperationDAO: ICreditCardOperationDAO,
        private val creditCardDAO: ICreditCardDAO,
) : ICreditCardOperationServiceAdapter {
    override fun getById(creditCardOperationId: String): CreditCardOperation? {
        return creditCardOperationDAO.getById(creditCardOperationId)
    }


    override fun rollbackOperation(creditCardCharge: CreditCardCharge) {
        val creditCard = creditCardDAO.getCreditCardById(creditCardCharge.creditCard)
                ?: throw EntityNotFoundException("Cartão de id: ${creditCardCharge.creditCard} não encontrado")

        creditCard.availableCreditLimit += creditCardCharge.purchaseValue
        creditCardDAO.updateAvailableCreditLimit(creditCard)

//        CreditCardOperation(
//                id = "", //will be auto-generated
//                creditCard = creditCardCharge.creditCard,
//                type = "Cobrança",
//                value = creditCardCharge.purchaseValue / creditCardCharge.installmentNumber,
//                description = "${creditCardCharge.description} $i/${creditCardCharge.installmentNumber}",
//                month = chargingPeriod.monthValue,
//                year = chargingPeriod.year
//        )

        creditCardDAO.save(creditCard)

    }
}