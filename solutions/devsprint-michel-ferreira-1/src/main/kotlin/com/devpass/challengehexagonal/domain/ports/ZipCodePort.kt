package com.devpass.challengehexagonal.domain.ports

import com.devpass.challengehexagonal.domain.model.Address

interface ZipCodePort {
    fun getZipCode(zipCode: String): Address
}