package com.devpass.challengehexagonal.application.controller

import com.devpass.challengehexagonal.resources.repository.ClientRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController(
    val clientRepository: ClientRepository
) {

    @GetMapping
    fun home(model: Model): String {
        model.addAttribute("clients", clientRepository.getClients())
        return "home"
    }
}