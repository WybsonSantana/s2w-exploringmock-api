package br.dev.s2w.exploring.mock.util.validation

import br.dev.s2w.exploring.mock.exception.BlankHeaderInputException
import br.dev.s2w.exploring.mock.util.constants.Constants

fun headerInputValidation(authorization: String) {
    if (authorization.isBlank()) {
        throw BlankHeaderInputException(Constants.HANDLE_UNAUTHORIZED_MESSAGE)
    }
}