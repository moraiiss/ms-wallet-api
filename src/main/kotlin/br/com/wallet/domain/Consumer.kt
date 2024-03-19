package br.com.wallet.domain

import br.com.wallet.application.dto.ConsumerDTO
import java.util.*

data class Consumer(
    val id: UUID? = null,
    val consumerDocument: String? = null,
    val name: String? = null,
    val email: String? = null,
    val password: String? = null

) {
    fun fromConsumerDto(consumerDto: ConsumerDTO) = Consumer(
        null,
        consumerDto.consumerDocument,
        consumerDto.name,
        consumerDto.email,
        consumerDto.password
    )
}
