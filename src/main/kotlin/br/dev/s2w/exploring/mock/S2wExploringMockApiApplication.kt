package br.dev.s2w.exploring.mock

import br.dev.s2w.exploring.mock.util.properties.ConfirmCustomerInfoProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(ConfirmCustomerInfoProperties::class)
class S2wExploringMockApiApplication

fun main(args: Array<String>) {
    runApplication<S2wExploringMockApiApplication>(*args)
}
