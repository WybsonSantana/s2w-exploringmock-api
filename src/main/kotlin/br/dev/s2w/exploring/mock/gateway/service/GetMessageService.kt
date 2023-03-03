package br.dev.s2w.exploring.mock.gateway.service

import br.dev.s2w.exploring.mock.domain.Message

interface GetMessageService {
    fun getMessage(authorization: String): Message
}