package br.dev.s2w.exploring.mock.gateway.usecase

import br.dev.s2w.exploring.mock.exception.InvalidHeaderException
import br.dev.s2w.exploring.mock.exception.InvalidRequestException
import br.dev.s2w.exploring.mock.gateway.service.CustomerInfoService
import br.dev.s2w.exploring.mock.util.GeneralBeans
import br.dev.s2w.exploring.mock.util.constants.Constants
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class CustomerInfoUsecaseTest : GeneralBeans() {

    @Mock
    private lateinit var customerInfoService: CustomerInfoService

    private lateinit var customerInfoUsecase: CustomerInfoUsecase

    @BeforeEach
    fun setup() {
        customerInfoUsecase = CustomerInfoUsecase(customerInfoService)
    }

    @Test
    fun `should return status 400 bad request when document number is blank`() {
        val authorization = super.getAuthorizationToken()
        val documentNumber = super.getBlankDocumentNumber()
        val customerId = super.getCustomerId()

        val exceptionResponse = assertThrows(InvalidRequestException::class.java) {
            customerInfoUsecase.execute(authorization, documentNumber, customerId)
        }

        assertEquals(Constants.HANDLE_BAD_REQUEST_MESSAGE, exceptionResponse.message)
    }

    @Test
    fun `should return status 400 bad request when customer id is blank`() {
        val authorization = super.getAuthorizationToken()
        val documentNumber = super.getDocumentNumber()
        val customerId = super.getBlankCustomerId()

        val exceptionResponse = assertThrows(InvalidRequestException::class.java) {
            customerInfoUsecase.execute(authorization, documentNumber, customerId)
        }

        assertEquals(Constants.HANDLE_BAD_REQUEST_MESSAGE, exceptionResponse.message)
    }

    @Test
    fun `should return status 401 unauthorized when authorization token is blank`() {
        val authorization = super.getBlankAuthorizationToken()
        val documentNumber = super.getDocumentNumber()
        val customerId = super.getCustomerId()

        val exceptionResponse = assertThrows(InvalidHeaderException::class.java) {
            customerInfoUsecase.execute(authorization, documentNumber, customerId)
        }

        assertEquals(Constants.HANDLE_UNAUTHORIZED_MESSAGE, exceptionResponse.message)
    }
}