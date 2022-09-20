package io.devpass.creditcard.data

import io.devpass.creditcard.dataaccess.IAntiFraudGateway
import io.devpass.creditcard.domain.objects.eligibility.CreditCardEligibility

class AntiFraudGateway : IAntiFraudGateway {
    override fun creditCardEligibility(document: String): CreditCardEligibility {
        TODO("Not yet implemented")
    }
}