package br.dev.s2w.exploring.mock.gateway.usecase

import br.dev.s2w.exploring.mock.domain.Message
import br.dev.s2w.exploring.mock.gateway.service.MessageService
import br.dev.s2w.exploring.mock.util.validation.requestValidation
import org.springframework.stereotype.Component

@Component
class MessageUsecase(
    private val messageService: MessageService
) {

    fun execute(authorization: String): Message {
        requestValidation(authorization)

        return messageService.getMessage(authorization)
    }
}