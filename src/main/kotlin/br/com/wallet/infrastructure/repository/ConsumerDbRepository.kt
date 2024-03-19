package br.com.wallet.infrastructure.repository

import br.com.wallet.application.interfaces.gateways.ConsumerRepository
import br.com.wallet.domain.Consumer
import br.com.wallet.infrastructure.repository.entity.ConsumerEntity
import org.springframework.stereotype.Component
import java.util.Optional
import java.util.UUID

@Component
class ConsumerDbRepository (val repository: SpringConsumerRepository) : ConsumerRepository {

    override fun findAll(): List<Consumer> {
        val entities: List<ConsumerEntity> = repository.findAll()

        return entities
            .map(ConsumerEntity::toConsumer)
            .toList()
    }

    override fun save(consumer: Consumer): Consumer {
        val entity = ConsumerEntity(consumer)

        return repository.save(entity)
            .toConsumer()
    }

    override fun findById(id: UUID): Optional<Consumer> {
        val entity = repository.findById(id)

        return entity
            .map(ConsumerEntity::toConsumer)
    }
}