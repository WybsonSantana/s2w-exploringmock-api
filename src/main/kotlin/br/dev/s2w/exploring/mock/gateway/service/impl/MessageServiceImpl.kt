package br.dev.s2w.exploring.mock.gateway.service.impl

import br.dev.s2w.exploring.mock.domain.Message
import br.dev.s2w.exploring.mock.gateway.client.MessageClient
import br.dev.s2w.exploring.mock.gateway.service.MessageService
import org.springframework.stereotype.Service

@Service
class MessageServiceImpl(
    private val messageClient: MessageClient
) : MessageService {

    override fun getMessage(authorization: String): Message {
        return messageClient.requestMessage(authorization)
    }
}