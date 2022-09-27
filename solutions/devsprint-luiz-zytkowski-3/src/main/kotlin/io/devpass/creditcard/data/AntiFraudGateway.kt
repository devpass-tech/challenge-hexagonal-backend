package io.devpass.creditcard.data

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.isSuccessful
import com.github.kittinunf.fuel.jackson.jacksonDeserializerOf
import io.devpass.creditcard.data.antifraud.response.CreditCardEligibilityResponses
import io.devpass.creditcard.data.http.response.DefaultHttpResponse
import io.devpass.creditcard.dataaccess.IAntiFraudGateway
import io.devpass.creditcard.domain.exceptions.GatewayException
import io.devpass.creditcard.domain.objects.antifraud.CreditCardEligibility


class AntiFraudGateway(
    private val baseUrl: String,
) : IAntiFraudGateway {
    override fun creditCardEligibility(CPF: String): CreditCardEligibility {
        val (_, result, response) = Fuel.get("$baseUrl/anti-fraud/credit-card-eligibility/$CPF")
            .responseObject<CreditCardEligibilityResponses>(jacksonDeserializerOf())
        return if (result.isSuccessful) {
            response.get().toCreditCardEligibility()
        } else {
            val fuelError = response.component2()
                ?: throw IllegalStateException("Request failed, but had null response body")
            val defaultHttpResponse = jacksonObjectMapper().readValue(fuelError.errorData, DefaultHttpResponse::class.java)
            throw GatewayException("Failed to fetch credit card elegibility. Response message: ${defaultHttpResponse.message}")
        }
    }
}