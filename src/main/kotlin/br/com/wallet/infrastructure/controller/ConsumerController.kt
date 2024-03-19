package br.com.wallet.infrastructure.controller

import br.com.wallet.application.dto.ConsumerDTO
import br.com.wallet.application.interfaces.usecases.ConsumerUseCase
import br.com.wallet.domain.Consumer
import br.com.wallet.infrastructure.commons.MediaType
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/v1/consumers")
@Tag(name = "Consumers", description = "Endpoints for managing consumers")
class ConsumerController (val useCases: ConsumerUseCase) {

    @GetMapping(
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML]
    )
    @Operation(summary = "List all consumers", description = "Returns all customers found")
    fun list(): ResponseEntity<List<Consumer>> = ResponseEntity.ok(useCases.list())

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML]
    )
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody consumerDTO: ConsumerDTO): ResponseEntity<Consumer> {
        val consumer: Consumer = useCases.create(consumerDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(consumer)
    }

    @GetMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML]
    )
    fun getConsumerById(@PathVariable id: UUID): ResponseEntity<Consumer> = ResponseEntity.ok(useCases.getConsumerById(id))
}