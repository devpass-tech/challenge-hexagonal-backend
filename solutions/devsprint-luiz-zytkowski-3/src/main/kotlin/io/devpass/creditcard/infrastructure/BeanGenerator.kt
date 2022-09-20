package io.devpass.creditcard.infrastructure

import io.devpass.creditcard.data.AntiFraudGateway
import io.devpass.creditcard.data.AccountManagementGateway
import io.devpass.creditcard.data.CreditCardDAO
import io.devpass.creditcard.data.repositories.CreditCardRepository
import io.devpass.creditcard.data.CreditCardOperationDAO
import io.devpass.creditcard.data.repositories.CreditCardOperationRepository
import io.devpass.creditcard.dataaccess.IAntiFraudGateway
import io.devpass.creditcard.dataaccess.IAccountManagementGateway
import io.devpass.creditcard.dataaccess.ICreditCardDAO
import io.devpass.creditcard.dataaccess.ICreditCardOperationDAO
import io.devpass.creditcard.domain.CreditCardOperationService
import io.devpass.creditcard.domain.CreditCardService
import io.devpass.creditcard.domainaccess.ICreditCardOperationServiceAdapter
import io.devpass.creditcard.domainaccess.ICreditCardServiceAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanGenerator {

    @Bean
    fun creditCardDAO(
        creditCardRepository: CreditCardRepository,
    ): ICreditCardDAO {
        return CreditCardDAO(creditCardRepository)
    }

    @Bean
    fun creditCardServiceAdapter(
        creditCardRepository: ICreditCardDAO,
    ): ICreditCardServiceAdapter {
        return CreditCardService(creditCardRepository)
    }

    @Bean
    fun creditCardOperationDAO(creditCardOperationRepository: CreditCardOperationRepository): ICreditCardOperationDAO {
        return CreditCardOperationDAO(creditCardOperationRepository)
    }

    @Bean
    fun creditCardOperationServiceAdapter(
        creditCardOperationDAO: ICreditCardOperationDAO,
    ): ICreditCardOperationServiceAdapter {
        return CreditCardOperationService(creditCardOperationDAO)
    }

    @Bean
    fun antiFraudGateway() : IAntiFraudGateway {
        return AntiFraudGateway()
    }
    
    @Bean
    fun accountManagementGateway(): IAccountManagementGateway {
        return AccountManagementGateway()
    }
}
