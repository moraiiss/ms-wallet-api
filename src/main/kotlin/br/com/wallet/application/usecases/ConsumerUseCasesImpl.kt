package br.com.wallet.application.usecases

import br.com.wallet.application.dto.ConsumerDTO
import br.com.wallet.application.interfaces.gateways.ConsumerRepository
import br.com.wallet.application.interfaces.usecases.ConsumerUseCase
import br.com.wallet.domain.commons.exceptions.BusinessException
import br.com.wallet.domain.Consumer
import org.springframework.stereotype.Service
import java.util.*

@Service
class ConsumerUseCasesImpl (val repository: ConsumerRepository) : ConsumerUseCase {

    override fun list(): List<Consumer> {
        return repository.findAll().map {
            Consumer(it.id, it.consumerDocument, it.name, it.email, it.password)
        }
    }

    override fun create(consumerDTO: ConsumerDTO): Consumer {
        val consumer = Consumer().fromConsumerDto(consumerDTO)

        return repository.save(consumer)
    }

    override fun getConsumerById(id: UUID): Consumer {

        val consumer: Optional<Consumer> = repository.findById(id)

        return consumer
            .map { Consumer(it.id, it.consumerDocument, it.name, it.email, it.password) }
            .orElseThrow { BusinessException("Consumer not found") }
    }
}