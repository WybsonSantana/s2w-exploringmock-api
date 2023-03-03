package br.dev.s2w.exploring.mock.gateway.http

import br.dev.s2w.exploring.mock.domain.Message
import br.dev.s2w.exploring.mock.gateway.usecase.GetMessageUsecase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class GetMessageController(
    private val getMessageUsecase: GetMessageUsecase
) {

    @GetMapping("/get-message")
    fun getMessage(@RequestHeader authorization: String): Message {
        return getMessageUsecase.execute(authorization)
    }
}