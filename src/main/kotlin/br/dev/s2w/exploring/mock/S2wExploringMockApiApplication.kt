package br.dev.s2w.exploring.mock

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class S2wExploringMockApiApplication

fun main(args: Array<String>) {
    runApplication<S2wExploringMockApiApplication>(*args)
}
