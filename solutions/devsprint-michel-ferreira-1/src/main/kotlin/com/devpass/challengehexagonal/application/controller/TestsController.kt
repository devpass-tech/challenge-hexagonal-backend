package com.devpass.challengehexagonal.application.controller

import com.devpass.challengehexagonal.domain.model.Account
import com.devpass.challengehexagonal.domain.model.Transaction
import com.devpass.challengehexagonal.domain.model.ValidationResult
import com.devpass.challengehexagonal.domain.service.rules.HighFrequencyTransactionRule
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

/*
    Classe temporária para criação de eventuais cenário de testes
 */
@RestController
@RequestMapping("tests")
class TestsController(
    val highFrequencyTransactionRule: HighFrequencyTransactionRule
) {

    @PostMapping("/high-frequency")
    fun test01(): ValidationResult {
        val account = Account(1, 123, 500.00, emptyList())
        val transaction = Transaction("Amazon", 400.00.toBigDecimal(), LocalDateTime.now())
        return highFrequencyTransactionRule.validate(account, transaction)
    }
}