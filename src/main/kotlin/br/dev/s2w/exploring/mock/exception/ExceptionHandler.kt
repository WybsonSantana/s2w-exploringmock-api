package br.dev.s2w.exploring.mock.exception

import br.dev.s2w.exploring.mock.domain.ErrorView
import br.dev.s2w.exploring.mock.util.constants.Constants
import feign.FeignException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MissingRequestHeaderException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(FeignException.BadRequest::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleFeignBadRequestException(request: HttpServletRequest): ErrorView {
        return ErrorView(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = Constants.HANDLE_BAD_REQUEST_MESSAGE,
            path = request.servletPath
        )
    }

    @ExceptionHandler(FeignException.Unauthorized::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun handleFeignUnauthorizedException(request: HttpServletRequest): ErrorView {
        return ErrorView(
            status = HttpStatus.UNAUTHORIZED.value(),
            error = HttpStatus.UNAUTHORIZED.name,
            message = Constants.HANDLE_UNAUTHORIZED_MESSAGE,
            path = request.servletPath
        )
    }

    @ExceptionHandler(FeignException.Forbidden::class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    fun handleFeignForbiddenException(request: HttpServletRequest): ErrorView {
        return ErrorView(
            status = HttpStatus.FORBIDDEN.value(),
            error = HttpStatus.FORBIDDEN.name,
            message = Constants.HANDLE_FORBIDDEN_MESSAGE,
            path = request.servletPath
        )
    }

    @ExceptionHandler(FeignException.NotFound::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleFeignNotFoundException(request: HttpServletRequest): ErrorView {
        return ErrorView(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = Constants.HANDLE_NOT_FOUND_MESSAGE,
            path = request.servletPath
        )
    }

    @ExceptionHandler(MissingRequestHeaderException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleMissingRequestHeaderException(request: HttpServletRequest): ErrorView {
        return ErrorView(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = Constants.HANDLE_BAD_REQUEST_MESSAGE,
            path = request.servletPath
        )
    }

    @ExceptionHandler(InvalidRequestException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleInvalidRequestException(exception: InvalidRequestException, request: HttpServletRequest): ErrorView {
        return ErrorView(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = exception.message!!,
            path = request.servletPath
        )
    }

    @ExceptionHandler(InvalidResponseException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleFeignInvalidResponse(exception: InvalidResponseException, request: HttpServletRequest): ErrorView {
        return ErrorView(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            message = exception.message!!,
            path = request.servletPath
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleFeignInternalServerErrorException(request: HttpServletRequest): ErrorView {
        return ErrorView(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            message = Constants.HANDLE_INTERNAL_SERVER_ERROR_MESSAGE,
            path = request.servletPath
        )
    }

}