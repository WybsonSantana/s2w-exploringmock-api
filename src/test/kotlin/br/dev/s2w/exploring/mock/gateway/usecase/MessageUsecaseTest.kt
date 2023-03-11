package br.dev.s2w.exploring.mock.gateway.usecase

import br.dev.s2w.exploring.mock.exception.InvalidHeaderException
import br.dev.s2w.exploring.mock.gateway.service.MessageService
import br.dev.s2w.exploring.mock.util.GeneralBeans
import br.dev.s2w.exploring.mock.util.constants.Constants
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class MessageUsecaseTest : GeneralBeans() {

    @Mock
    private lateinit var messageService: MessageService

    private lateinit var messageUsecase: MessageUsecase

    @BeforeEach
    fun setup() {
        messageUsecase = MessageUsecase(messageService)
    }

    @Test
    fun `should return 401 unauthorized when authorization header is blank`() {
        val exceptionResponse = assertThrows(InvalidHeaderException::class.java) {
            messageUsecase.execute(super.getBlankAuthorizationToken())
        }

        assertEquals(Constants.HANDLE_UNAUTHORIZED_MESSAGE, exceptionResponse.message)
    }
}