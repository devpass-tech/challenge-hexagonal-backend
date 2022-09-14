package io.devpass.creditcard.transport.controllers

import io.devpass.creditcard.domainaccess.ICreditCardServiceAdapter
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("credit-cards")
class CreditCardController(
    creditCardServiceAdapter: ICreditCardServiceAdapter
) {

}