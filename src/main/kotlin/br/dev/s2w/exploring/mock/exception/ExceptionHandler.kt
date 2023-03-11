package br.dev.s2w.exploring.mock.exception

import br.dev.s2w.exploring.mock.domain.ErrorView
import br.dev.s2w.exploring.mock.util.constants.Constants
import br.dev.s2w.exploring.mock.util.logger.logError
import feign.FeignException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MissingRequestHeaderException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest
import br.dev.s2w.exploring.mock.exception.ExceptionHandler as _ExceptionHandler

@RestControllerAdvice
class ExceptionHandler {

    private val logger: Logger = LoggerFactory.getLogger(_ExceptionHandler::class.java)

    @ExceptionHandler(FeignException.BadRequest::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleFeignBadRequestException(request: HttpServletRequest): ErrorView {
        val httpStatus = HttpStatus.BAD_REQUEST
        val message = Constants.HANDLE_BAD_REQUEST_MESSAGE

        return ErrorView(
            status = httpStatus.value(),
            error = httpStatus.name,
            message = message,
            path = request.servletPath
        ).also {
            logError(logger, "${httpStatus.value()} ${httpStatus.name} - $message")
        }
    }

    @ExceptionHandler(FeignException.Unauthorized::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun handleFeignUnauthorizedException(request: HttpServletRequest): ErrorView {
        val httpStatus = HttpStatus.UNAUTHORIZED
        val message = Constants.HANDLE_UNAUTHORIZED_MESSAGE

        return ErrorView(
            status = httpStatus.value(),
            error = httpStatus.name,
            message = message,
            path = request.servletPath
        ).also {
            logError(logger, "${httpStatus.value()} ${httpStatus.name} - $message")
        }
    }

    @ExceptionHandler(FeignException.Forbidden::class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    fun handleFeignForbiddenException(request: HttpServletRequest): ErrorView {
        val httpStatus = HttpStatus.FORBIDDEN
        val message = Constants.HANDLE_FORBIDDEN_MESSAGE

        return ErrorView(
            status = httpStatus.value(),
            error = httpStatus.name,
            message = message,
            path = request.servletPath
        ).also {
            logError(logger, "${httpStatus.value()} ${httpStatus.name} - $message")
        }
    }

    @ExceptionHandler(FeignException.NotFound::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleFeignNotFoundException(request: HttpServletRequest): ErrorView {
        val httpStatus = HttpStatus.NOT_FOUND
        val message = Constants.HANDLE_NOT_FOUND_MESSAGE

        return ErrorView(
            status = httpStatus.value(),
            error = httpStatus.name,
            message = message,
            path = request.servletPath
        ).also {
            logError(logger, "${httpStatus.value()} ${httpStatus.name} - $message")
        }
    }

    @ExceptionHandler(MissingRequestHeaderException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleMissingRequestHeaderException(request: HttpServletRequest): ErrorView {
        val httpStatus = HttpStatus.BAD_REQUEST
        val message = Constants.HANDLE_BAD_REQUEST_MESSAGE

        return ErrorView(
            status = httpStatus.value(),
            error = httpStatus.name,
            message = message,
            path = request.servletPath
        ).also {
            logError(logger, "${httpStatus.value()} ${httpStatus.name} - $message")
        }
    }

    @ExceptionHandler(InvalidHeaderException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun handleBlankHeaderInputRequestException(
        exception: InvalidHeaderException,
        request: HttpServletRequest
    ): ErrorView {
        val httpStatus = HttpStatus.UNAUTHORIZED
        val message = exception.message!!

        return ErrorView(
            status = httpStatus.value(),
            error = httpStatus.name,
            message = message,
            path = request.servletPath
        ).also {
            logError(logger, "${httpStatus.value()} ${httpStatus.name} - $message")
        }
    }

    @ExceptionHandler(InvalidRequestException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleInvalidRequestException(exception: InvalidResponseException, request: HttpServletRequest): ErrorView {
        val httpStatus = HttpStatus.BAD_REQUEST
        val message = exception.message!!

        return ErrorView(
            status = httpStatus.value(),
            error = httpStatus.name,
            message = message,
            path = request.servletPath
        ).also {
            logError(logger, "${httpStatus.value()} ${httpStatus.name} - $message")
        }
    }

    @ExceptionHandler(InvalidResponseException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleInvalidResponseException(exception: InvalidResponseException, request: HttpServletRequest): ErrorView {
        val httpStatus = HttpStatus.INTERNAL_SERVER_ERROR
        val message = exception.message!!

        return ErrorView(
            status = httpStatus.value(),
            error = httpStatus.name,
            message = message,
            path = request.servletPath
        ).also {
            logError(logger, "${httpStatus.value()} ${httpStatus.name} - $message")
        }
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleInternalServerErrorException(request: HttpServletRequest): ErrorView {
        val httpStatus = HttpStatus.INTERNAL_SERVER_ERROR
        val message = Constants.HANDLE_INTERNAL_SERVER_ERROR_MESSAGE

        return ErrorView(
            status = httpStatus.value(),
            error = httpStatus.name,
            message = message,
            path = request.servletPath
        ).also {
            logError(logger, "${httpStatus.value()} ${httpStatus.name} - $message")
        }
    }
}