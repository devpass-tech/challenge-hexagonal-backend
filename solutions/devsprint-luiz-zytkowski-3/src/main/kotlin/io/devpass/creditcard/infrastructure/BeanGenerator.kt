package io.devpass.creditcard.infrastructure

import io.devpass.creditcard.dataaccess.ICreditCardRepository
import io.devpass.creditcard.domain.CreditCardService
import io.devpass.creditcard.domainaccess.ICreditCardServiceAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanGenerator {

    @Bean
    fun creditCardRepository(): ICreditCardRepository {
        TODO()
    }

    @Bean
    fun creditCardServiceAdapter(
        creditCardRepository: ICreditCardRepository,
    ): ICreditCardServiceAdapter {
        return CreditCardService(creditCardRepository)
    }
}
