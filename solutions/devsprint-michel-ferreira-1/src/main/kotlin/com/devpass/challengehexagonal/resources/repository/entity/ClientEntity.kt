package com.devpass.challengehexagonal.resources.repository.entity

import com.devpass.challengehexagonal.domain.model.Client
import java.time.LocalDate
import javax.persistence.*

@Entity(name = "client")
data class ClientEntity(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        val name: String,

        val birthDate: LocalDate,

        @OneToOne(cascade = [CascadeType.ALL])
        val account: AccountEntity
) {
    fun toDomain() = Client(
            name = this.name,
            birthDate = this.birthDate,
            account = this.account
    )
}


