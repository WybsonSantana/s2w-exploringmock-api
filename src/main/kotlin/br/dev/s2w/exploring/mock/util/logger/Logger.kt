package br.dev.s2w.exploring.mock.util.logger

import org.slf4j.Logger

fun logDebug(logger: Logger, message: String) {
    logger.debug(message)
}

fun logError(logger: Logger, message: String) {
    logger.error(message)
}