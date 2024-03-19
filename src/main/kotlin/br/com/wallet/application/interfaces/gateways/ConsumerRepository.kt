package br.com.wallet.application.interfaces.gateways

import br.com.wallet.domain.Consumer
import java.util.*
import kotlin.collections.List

interface ConsumerRepository {

    fun findAll(): List<Consumer>

    fun save(consumer: Consumer): Consumer

    fun findById(id: UUID): Optional<Consumer>
}