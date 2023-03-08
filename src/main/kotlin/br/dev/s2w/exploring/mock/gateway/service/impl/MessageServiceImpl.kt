package br.dev.s2w.exploring.mock.gateway.service.impl

import br.dev.s2w.exploring.mock.domain.Message
import br.dev.s2w.exploring.mock.exception.InvalidResponseException
import br.dev.s2w.exploring.mock.gateway.client.MessageClient
import br.dev.s2w.exploring.mock.gateway.service.MessageService
import br.dev.s2w.exploring.mock.util.constants.Constants
import br.dev.s2w.exploring.mock.util.logger.logDebug
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class MessageServiceImpl(
    private val messageClient: MessageClient
) : MessageService {

    private val logger: Logger = LoggerFactory.getLogger(MessageServiceImpl::class.java)

    override fun getMessage(authorization: String): Message {
        logDebug(logger, "Starting service to request message...")

        val response = messageClient.requestMessage(authorization)

        if (isInvalidResponse(response)) {
            throw InvalidResponseException(Constants.HANDLE_INTERNAL_SERVER_ERROR_MESSAGE)
        }

        return response.body!!.also {
            logDebug(logger, "Finishing service to request message...")
        }
    }

    private fun isInvalidResponse(response: ResponseEntity<Message>): Boolean {
        return !response.hasBody() || response.body!!.message.isBlank()
    }
}