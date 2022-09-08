package com.devpass.challengehexagonal.application.controller

import com.devpass.challengehexagonal.domain.service.ClientManagerServicePort
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("clients")
class ClientController(
    val clientManagerServicePort: ClientManagerServicePort
) {
}