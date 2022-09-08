package com.devpass.challengehexagonal.domain.ports

import com.devpass.challengehexagonal.domain.model.ZipCode

interface ZipCodePort {
    fun getZipCode(zipCode: String): ZipCode
}