package br.dev.s2w.exploring.mock.gateway.service.impl

import br.dev.s2w.exploring.mock.domain.Message
import br.dev.s2w.exploring.mock.gateway.client.GetMessageClient
import br.dev.s2w.exploring.mock.gateway.service.GetMessageService
import org.springframework.stereotype.Service

@Service
class GetMessageServiceImpl(
    private val getMessageClient: GetMessageClient
) : GetMessageService {

    override fun getMessage(authorization: String): Message {
        return getMessageClient.requestMessage(authorization)
    }
}