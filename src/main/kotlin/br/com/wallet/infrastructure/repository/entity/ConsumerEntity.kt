package br.com.wallet.infrastructure.repository.entity

import br.com.wallet.domain.Consumer
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "consumers")
data class ConsumerEntity(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: UUID?,
    @Column(unique = true) val consumerDocument: String?,
    val name: String?,
    @Column(unique = true) val email: String?,
    val password: String?
) {

    constructor(
        consumer: Consumer
    ) : this(
        null,
        consumer.consumerDocument,
        consumer.name,
        consumer.email,
        consumer.password
    )

    fun toConsumer(): Consumer {
        return Consumer(
            id,
            consumerDocument,
            name,
            email,
            password
        )
    }
}
