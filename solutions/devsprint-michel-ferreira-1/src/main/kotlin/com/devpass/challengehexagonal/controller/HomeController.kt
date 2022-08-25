package com.devpass.challengehexagonal.controller

import com.devpass.challengehexagonal.model.repository.ClientRepository
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