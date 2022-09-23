package io.devpass.creditcard.data

import io.devpass.creditcard.data.entities.CreditCardOperationEntity
import io.devpass.creditcard.data.repositories.CreditCardOperationRepository
import io.devpass.creditcard.dataaccess.ICreditCardOperationDAO
import io.devpass.creditcard.domain.objects.CreditCardOperation

class CreditCardOperationDAO(
    private val creditCardOperationRepository: CreditCardOperationRepository,
) : ICreditCardOperationDAO {
    override fun getById(id: String): CreditCardOperation? {
        val creditCardOperationEntity = creditCardOperationRepository.findById(id)
        return if (creditCardOperationEntity.isPresent) creditCardOperationEntity.get()
            .toCreditCardOperation() else null
    }

    override fun save(creditCardOperation: CreditCardOperation): CreditCardOperation {
        return creditCardOperationRepository.save(CreditCardOperationEntity.fromCreditCardOperation(creditCardOperation))
            .toCreditCardOperation()
    }

}