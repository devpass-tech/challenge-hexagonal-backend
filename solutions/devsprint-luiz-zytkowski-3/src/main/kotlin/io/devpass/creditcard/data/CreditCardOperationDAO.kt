package io.devpass.creditcard.data

import io.devpass.creditcard.data.repositories.CreditCardOperationRepository
import io.devpass.creditcard.dataaccess.ICreditCardOperationDAO
import io.devpass.creditcard.domain.objects.CreditCardOperation

class CreditCardOperationDAO(
    private val creditCardOperationRepository: CreditCardOperationRepository,
) : ICreditCardOperationDAO {
    override fun getById(id: String): CreditCardOperation? {
        val creditCardOperationEntity = creditCardOperationRepository.findById(id)
        return if (creditCardOperationEntity.isPresent) creditCardOperationEntity.get().toCreditCardOperation() else null
    }

}