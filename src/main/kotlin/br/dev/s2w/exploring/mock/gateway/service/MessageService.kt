package br.dev.s2w.exploring.mock.gateway.service

import br.dev.s2w.exploring.mock.domain.Message

interface MessageService {
    fun getMessage(authorization: String): Message
}