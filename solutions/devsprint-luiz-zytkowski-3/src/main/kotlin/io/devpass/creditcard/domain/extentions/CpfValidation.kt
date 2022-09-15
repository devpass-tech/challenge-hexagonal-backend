package io.devpass.creditcard.domain.extentions

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