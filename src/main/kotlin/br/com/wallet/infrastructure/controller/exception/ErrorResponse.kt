package br.com.wallet.infrastructure.controller.exception

import java.time.OffsetDateTime

data class ErrorResponse (
    val timestamp: OffsetDateTime,
    val message: String?,
    val exception: String
)