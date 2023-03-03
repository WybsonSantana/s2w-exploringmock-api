package br.dev.s2w.exploring.mock.gateway.usecase

import br.dev.s2w.exploring.mock.domain.Message
import br.dev.s2w.exploring.mock.gateway.service.GetMessageService
import org.springframework.stereotype.Component

@Component
class GetMessageUsecase(
    private val getMessageService: GetMessageService
) {

    fun execute(authorization: String): Message {
        return getMessageService.getMessage(authorization)
    }
}