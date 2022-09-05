package com.devpass.challengehexagonal.domain.ports

import com.devpass.challengehexagonal.domain.model.Location

interface LocationPort {
    fun findByZipCode(zipCode: String) : Location
}