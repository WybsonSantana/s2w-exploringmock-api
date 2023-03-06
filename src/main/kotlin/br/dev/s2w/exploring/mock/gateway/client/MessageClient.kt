package br.dev.s2w.exploring.mock.gateway.client

import br.dev.s2w.exploring.mock.domain.Message
import br.dev.s2w.exploring.mock.util.constants.Constants
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping

@FeignClient(name = Constants.GET_MESSAGE_CLIENT_NAME, url = "\${api.get.message.client.url}")
interface MessageClient {

    @RequestMapping("/v1/mock/messages")
    fun requestMessage(@RequestHeader authorization: String): ResponseEntity<Message>

}