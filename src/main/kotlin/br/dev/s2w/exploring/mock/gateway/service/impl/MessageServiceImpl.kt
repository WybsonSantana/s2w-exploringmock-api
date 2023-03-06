package br.dev.s2w.exploring.mock.gateway.service.impl

import br.dev.s2w.exploring.mock.domain.Message
import br.dev.s2w.exploring.mock.exception.InvalidRequestException
import br.dev.s2w.exploring.mock.exception.InvalidResponseException
import br.dev.s2w.exploring.mock.gateway.client.MessageClient
import br.dev.s2w.exploring.mock.gateway.service.MessageService
import br.dev.s2w.exploring.mock.util.constants.Constants
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class MessageServiceImpl(
    private val messageClient: MessageClient
) : MessageService {

    override fun getMessage(authorization: String): Message {
        if (authorization.isBlank()) {
            throw InvalidRequestException(Constants.HANDLE_BAD_REQUEST_MESSAGE)
        }

        val response = messageClient.requestMessage(authorization)

        if (isInvalidResponse(response)) {
            throw InvalidResponseException(Constants.HANDLE_INTERNAL_SERVER_ERROR_MESSAGE)
        }

        return response.body!!
    }

    private fun isInvalidResponse(response: ResponseEntity<Message>): Boolean {
        return !response.hasBody() || response.body!!.message.isBlank()
    }
}