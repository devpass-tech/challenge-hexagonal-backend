package com.devpass.challengehexagonal.application.controller

import com.devpass.challengehexagonal.resources.repository.ClientAdapterRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController(
    val clientAdapterRepository: ClientAdapterRepository
) {

    @GetMapping
    fun home(model: Model): String {
        model.addAttribute("clients", clientAdapterRepository.getClients())
        return "home"
    }
}