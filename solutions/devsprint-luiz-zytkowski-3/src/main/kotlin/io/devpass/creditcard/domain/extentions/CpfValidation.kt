package io.devpass.creditcard.domain.extentions

import io.devpass.creditcard.domain.exceptions.OwnedException

fun String.validateAsCPF(): Boolean {
    var ownerCPF = this.filter { it.isDigit() }.map {
        it.toString().toInt()
    }
    if (ownerCPF.size != 11) { //must validade if it is different from 11 digits
        return false
    }
    if (ownerCPF.all { it == ownerCPF[0]}) { //must validate if the numbers are the same
        return false
    }
    return true
}
fun String.notAValidCPF(): OwnedException {
    var invalidCPF = this.filter { it.isDigit() }.map {
        it.toString().toInt()
    }
    if(invalidCPF.isEmpty()) {
        throw Exception("O campo do CPF é obrigatório.")
    }
    return OwnedException("O CPF inserido é inválido.")
}