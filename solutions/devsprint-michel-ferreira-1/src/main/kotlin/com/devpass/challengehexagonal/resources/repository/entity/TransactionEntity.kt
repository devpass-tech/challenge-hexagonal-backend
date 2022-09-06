package com.devpass.challengehexagonal.resources.repository.entity

import com.devpass.challengehexagonal.domain.model.Transaction
import org.hibernate.annotations.CreationTimestamp
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "transaction")
data class TransactionEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val establishment: String,

    @CreationTimestamp
    val transactionDate: LocalDateTime = LocalDateTime.now(),

    val value: BigDecimal,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    val account: AccountEntity,

    @OneToOne(cascade = [CascadeType.ALL])
    val location: LocationEntity
) {
    fun toDomain() = Transaction(
        establishment = this.establishment,
        value = this.value,
        transactionDate = this.transactionDate
    )
}
