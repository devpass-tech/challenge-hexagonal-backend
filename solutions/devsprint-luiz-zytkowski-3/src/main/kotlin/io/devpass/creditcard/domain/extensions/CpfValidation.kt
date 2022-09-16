package io.devpass.creditcard.domain.extensions

fun validateAsCPF(ownerCPF: String): Boolean {
    if (ownerCPF.all { it == ownerCPF[0] } || ownerCPF.length != 11 || ownerCPF.isEmpty())
        return false
    val dig10: Char
    val dig11: Char
    var sm: Int
    var i: Int
    var r: Int
    var num: Int
    var peso: Int

    return try {
        sm = 0
        peso = 10
        i = 0
        while (i < 9) {

            num = (ownerCPF[i].code - 48)
            sm += num * peso
            peso -= 1
            i++
        }
        r = 11 - sm % 11
        dig10 = if (r == 10 || r == 11) '0' else (r + 48).toChar()
        sm = 0
        peso = 11
        i = 0
        while (i < 10) {
            num = (ownerCPF[i].code - 48)
            sm += num * peso
            peso -= 1
            i++
        }
        r = 11 - sm % 11
        dig11 = if (r == 10 || r == 11) '0' else (r + 48).toChar()

        if (dig10 == ownerCPF[9] && dig11 == ownerCPF[10]) true
        else
            false
    } catch (error: Exception) {
        false
    }
}