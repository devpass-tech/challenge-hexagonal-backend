package io.devpass.creditcard.data

import io.devpass.creditcard.data.entities.CreditCardOperationEntity
import io.devpass.creditcard.data.repositories.CreditCardOperationRepository
import io.devpass.creditcard.dataaccess.ICreditCardOperationDAO
import io.devpass.creditcard.domain.objects.CreditCardOperation
import java.util.*

class CreditCardOperationDAO(
    private val creditCardOperationRepository: CreditCardOperationRepository,
) : ICreditCardOperationDAO {

    override fun getById(id: String): CreditCardOperation? {
        val creditCardOperationEntity = creditCardOperationRepository.findById(id)
        return if (creditCardOperationEntity.isPresent) creditCardOperationEntity.get()
            .toCreditCardOperation() else null
    }

    override fun rollbackOperation(creditCardOperation: CreditCardOperation): CreditCardOperation {
        return creditCardOperationRepository.save(
            CreditCardOperationEntity(
                id = UUID.randomUUID().toString(),
                creditCard = creditCardOperation.creditCard,
                type = creditCardOperation.type,
                month = creditCardOperation.month,
                year = creditCardOperation.year,
                value = creditCardOperation.value,
                description = creditCardOperation.description,
            )
        ).toCreditCardOperation()
    }

    override fun save(creditCardOperation: CreditCardOperation): CreditCardOperation {
        return creditCardOperationRepository.save(
            CreditCardOperationEntity(
                id = UUID.randomUUID().toString(),
                creditCard = creditCardOperation.creditCard,
                type = creditCardOperation.type,
                month = creditCardOperation.month,
                year = creditCardOperation.year,
                value = creditCardOperation.value,
                description = creditCardOperation.description
            )
        ).toCreditCardOperation()
    }

    override fun operationReport(id: String, month: Int, year: Int): List<CreditCardOperation> {
        return creditCardOperationRepository.listByPeriod(id, month, year).map { it.toCreditCardOperation() }
    }
}