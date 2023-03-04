package br.dev.s2w.exploring.mock.util.properties

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@ConfigurationProperties(prefix = "confirm.customer.info")
data class ConfirmCustomerInfoProperties(
    val title: String,
    val subtitle: String,
    val continueButtonLabel: String,
    val cancelButtonLabel: String,
    val warningMessage: String
)