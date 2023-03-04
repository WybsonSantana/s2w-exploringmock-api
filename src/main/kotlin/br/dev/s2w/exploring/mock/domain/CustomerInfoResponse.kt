package br.dev.s2w.exploring.mock.domain

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CustomerInfoResponse(
    val pageTitle: String,
    val pageSubtitle: String,
    val customerName: String,
    val customerDocumentNumber: String,
    val customerEmailAddress: String,
    val pageContinueButtonLabel: String,
    val pageCancelButtonLabel: String,
    val pageWarningMessage: String
)