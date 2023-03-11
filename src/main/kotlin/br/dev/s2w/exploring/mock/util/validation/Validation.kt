package br.dev.s2w.exploring.mock.util.validation

import br.dev.s2w.exploring.mock.exception.InvalidHeaderException
import br.dev.s2w.exploring.mock.exception.InvalidRequestException
import br.dev.s2w.exploring.mock.util.constants.Constants

fun requestValidation(authorization: String, documentNumber: String, customerId: String) {
    requestValidation(authorization)

    if (documentNumber.isBlank() || customerId.isBlank()) {
        throw InvalidRequestException(Constants.HANDLE_BAD_REQUEST_MESSAGE)
    }
}

fun requestValidation(authorization: String) {
    if (authorization.isBlank()) {
        throw InvalidHeaderException(Constants.HANDLE_UNAUTHORIZED_MESSAGE)
    }
}