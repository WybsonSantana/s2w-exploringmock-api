package br.dev.s2w.exploring.mock.gateway.service.impl

import br.dev.s2w.exploring.mock.exception.InvalidResponseException
import br.dev.s2w.exploring.mock.gateway.client.MessageClient
import br.dev.s2w.exploring.mock.gateway.service.MessageService
import br.dev.s2w.exploring.mock.util.GeneralBeans
import br.dev.s2w.exploring.mock.util.constants.Constants
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class MessageServiceImplTest : GeneralBeans() {

    @Mock
    private lateinit var messageClient: MessageClient

    private lateinit var messageService: MessageService

    @BeforeEach
    fun setup() {
        messageService = MessageServiceImpl(messageClient)
    }

    @Test
    fun `should return a message`() {
        `when`(messageClient.requestMessage(super.getAuthorizationToken()))
            .thenReturn(super.getMessageClientResponse())

        val expected = super.getMessage()
        val actual = messageService.getMessage(super.getAuthorizationToken())

        assertEquals(expected.message, actual.message)
    }

    @Test
    fun `should return status 500 internal server error when client response is invalid`() {
        `when`(messageClient.requestMessage(super.getAuthorizationToken()))
            .thenReturn(super.getMessageClientResponseWithBlankAttribute())

        val exceptionResponse = assertThrows(InvalidResponseException::class.java) {
            messageService.getMessage(super.getAuthorizationToken())
        }

        assertEquals(Constants.HANDLE_INTERNAL_SERVER_ERROR_MESSAGE, exceptionResponse.message)
    }
}