package br.dev.s2w.exploring.mock.gateway.http

import br.dev.s2w.exploring.mock.domain.Message
import br.dev.s2w.exploring.mock.gateway.usecase.MessageUsecase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/message")
class MessageController(
    private val messageUsecase: MessageUsecase
) {

    @GetMapping("/get")
    fun getMessage(@RequestHeader authorization: String): Message {
        return messageUsecase.execute(authorization)
    }
}