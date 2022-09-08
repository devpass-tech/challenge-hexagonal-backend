package com.devpass.challengehexagonal.application.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate


@Configuration
class SpringRestConfig {

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }

}
