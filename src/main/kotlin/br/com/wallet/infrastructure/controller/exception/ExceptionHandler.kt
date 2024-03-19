package br.com.wallet.infrastructure.controller.exception

import br.com.wallet.domain.commons.exceptions.BusinessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.OffsetDateTime

@ControllerAdvice
@RestController
class ExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleInternalExceptions(ex: Exception, request: WebRequest): ResponseEntity<ErrorResponse> {
        val response = ErrorResponse(
            OffsetDateTime.now(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(BusinessException::class)
    fun handleBadRequestExceptions(ex: Exception, request: WebRequest): ResponseEntity<ErrorResponse> {
        val response = ErrorResponse(
            OffsetDateTime.now(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST)
    }
}