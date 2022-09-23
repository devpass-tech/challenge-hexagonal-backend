package io.devpass.creditcard.data

import io.devpass.creditcard.data.repositories.CreditCardOperationRepository
import io.devpass.creditcard.dataaccess.ICreditCardOperationDAO
import io.devpass.creditcard.domain.CreditCardOperationService
import io.devpass.creditcard.domain.objects.CreditCardOperation

class CreditCardOperationDAO(
    private val creditCardOperationRepository: CreditCardOperationRepository,
    private val creditCardOperationService: CreditCardOperationService,
) : ICreditCardOperationDAO {
    override fun getById(id: String): CreditCardOperation? {
        val creditCardOperationEntity = creditCardOperationRepository.findById(id)
        return if (creditCardOperationEntity.isPresent) creditCardOperationEntity.get()
            .toCreditCardOperation() else null
    }

    override fun operationReport(id: String, month: Int, year: Int): List<CreditCardOperation?> {
        val creditCardOperationService = creditCardOperationService.operationReport(id, month, year)
//        return if (creditCardOperationService.isNotEmpty())
    }
}