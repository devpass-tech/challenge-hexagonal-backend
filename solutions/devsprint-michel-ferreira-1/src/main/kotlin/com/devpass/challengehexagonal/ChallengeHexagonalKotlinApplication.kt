package com.devpass.challengehexagonal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class ChallengeHexagonalKotlinApplication

fun main(args: Array<String>) {
	runApplication<ChallengeHexagonalKotlinApplication>(*args)
}