package io.devpass.creditcard.infrastructure

import io.devpass.creditcard.data.*
import io.devpass.creditcard.data.repositories.CreditCardInvoiceRepository
import io.devpass.creditcard.data.repositories.CreditCardOperationRepository
import io.devpass.creditcard.data.repositories.CreditCardRepository
import io.devpass.creditcard.dataaccess.*
import io.devpass.creditcard.domain.CreditCardInvoiceService
import io.devpass.creditcard.domain.CreditCardOperationService
import io.devpass.creditcard.domain.CreditCardService
import io.devpass.creditcard.domainaccess.ICreditCardInvoiceServiceAdapter
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
        accountManagementGateway: IAccountManagementGateway,
        antiFraudGateway: IAntiFraudGateway,
    ): ICreditCardServiceAdapter {
        return CreditCardService(creditCardRepository, accountManagementGateway, antiFraudGateway)
    }

    @Bean
    fun creditCardOperationDAO(creditCardOperationRepository: CreditCardOperationRepository): ICreditCardOperationDAO {
        return CreditCardOperationDAO(creditCardOperationRepository)
    }

    @Bean
    fun creditCardOperationServiceAdapter(
        creditCardDAO: ICreditCardDAO,
        creditCardOperationDAO: ICreditCardOperationDAO,
    ): ICreditCardOperationServiceAdapter {
        return CreditCardOperationService(
            creditCardOperationDAO,
            creditCardDAO,
        )
    }

    @Bean
    fun creditCardInvoiceDAO(
        creditCardInvoiceRepository: CreditCardInvoiceRepository,
    ): ICreditCardInvoiceDAO {
        return CreditCardInvoiceDAO(creditCardInvoiceRepository)
    }

    @Bean
    fun creditCardInvoiceServiceAdapter(
        creditCardDAO: ICreditCardDAO,
        creditCardInvoiceDAO: ICreditCardInvoiceDAO,
        creditCardOperationDAO: ICreditCardOperationDAO,
        accountManagementGateway: IAccountManagementGateway,
    ): ICreditCardInvoiceServiceAdapter {
        return CreditCardInvoiceService(
            creditCardDAO,
            creditCardInvoiceDAO,
            creditCardOperationDAO,
            accountManagementGateway,
        )
    }

    @Bean
    fun antiFraudGateway(): IAntiFraudGateway {
        return AntiFraudGateway("http://localhost:7444")
    }

    @Bean
    fun accountManagementGateway(): IAccountManagementGateway {
        return AccountManagementGateway("http://localhost:7445")
    }
}
