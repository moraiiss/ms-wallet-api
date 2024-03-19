package br.com.wallet.infraestructure.controller

import br.com.wallet.application.interfaces.usecases.ConsumerUseCase
import br.com.wallet.domain.Consumer
import br.com.wallet.infrastructure.controller.ConsumerController
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.util.*

class ConsumerControllerTest {

    @Mock
    lateinit var useCases: ConsumerUseCase

    private lateinit var mockMvc: MockMvc
    private lateinit var mock: AutoCloseable

    @BeforeEach
    fun setUp() {
        mock = MockitoAnnotations.openMocks(this)
        mockMvc = MockMvcBuilders.standaloneSetup(ConsumerController(useCases)).build()
    }

    @AfterEach
    fun tearDown() {
        mock.close()
    }

    @Test
    fun testReturnShouldBeValidWhenValueIsConsumerList() {

        val consumerList = listOf (
            Consumer(UUID.randomUUID(), "123.098.345-08", "John Doe", "teste@teste.com", "123456")
        )

        `when`(useCases.list()).thenReturn(consumerList)

        mockMvc.perform(get("/v1/consumers"))
            .andExpect(status().isOk)
    }
}