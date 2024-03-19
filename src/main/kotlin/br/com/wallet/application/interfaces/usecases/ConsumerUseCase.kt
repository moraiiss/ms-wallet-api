package br.com.wallet.application.interfaces.usecases

import br.com.wallet.application.dto.ConsumerDTO
import br.com.wallet.domain.Consumer
import java.util.UUID

interface ConsumerUseCase {

    fun list(): List<Consumer>

    fun create(consumerDTO: ConsumerDTO): Consumer

    fun getConsumerById(id: UUID): Consumer
}