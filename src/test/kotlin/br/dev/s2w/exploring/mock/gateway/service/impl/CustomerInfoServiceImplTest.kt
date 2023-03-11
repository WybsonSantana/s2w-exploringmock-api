package br.dev.s2w.exploring.mock.gateway.service.impl

import br.dev.s2w.exploring.mock.exception.InvalidResponseException
import br.dev.s2w.exploring.mock.gateway.client.CustomerInfoClient
import br.dev.s2w.exploring.mock.gateway.service.CustomerInfoService
import br.dev.s2w.exploring.mock.util.GeneralBeans
import br.dev.s2w.exploring.mock.util.constants.Constants
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class CustomerInfoServiceImplTest : GeneralBeans() {

    @Mock
    private lateinit var customerInfoClient: CustomerInfoClient

    private lateinit var customerInfoService: CustomerInfoService

    @BeforeEach
    fun setup() {
        customerInfoService = CustomerInfoServiceImpl(customerInfoClient, confirmCustomerInfoProperties)
    }

    @Test
    fun `should return a customer confirm info`() {
        val authorization = super.getAuthorizationToken()
        val documentNumber = super.getDocumentNumber()
        val customerId = super.getCustomerId()

        `when`(customerInfoClient.requestCustomerInfo(authorization, documentNumber, customerId))
            .thenReturn(super.getCustomerDTOClientResponse())

        val expected = super.getCustomerInfoResponse().body!!
        val actual = customerInfoService.getCustomerInfo(authorization, documentNumber, customerId)

        assertEquals(expected.pageTitle, actual.pageTitle)
        assertEquals(expected.pageSubtitle, actual.pageSubtitle)
        assertEquals(expected.customerName, actual.customerName)
        assertEquals(expected.customerDocumentNumber, actual.customerDocumentNumber)
        assertEquals(expected.customerEmailAddress, actual.customerEmailAddress)
        assertEquals(expected.pageContinueButtonLabel, actual.pageContinueButtonLabel)
        assertEquals(expected.pageCancelButtonLabel, actual.pageCancelButtonLabel)
        assertEquals(expected.pageWarningMessage, actual.pageWarningMessage)
    }

    @Test
    fun `should return status 500 internal server error when client response is invalid`() {
        val authorization = super.getAuthorizationToken()
        val documentNumber = super.getDocumentNumber()
        val customerId = super.getCustomerId()

        `when`(customerInfoClient.requestCustomerInfo(authorization, documentNumber, customerId))
            .thenReturn(super.getCustomerDTOClientResponseWithBlankAttribute())

        val exceptionResponse = assertThrows(InvalidResponseException::class.java) {
            customerInfoService.getCustomerInfo(authorization, documentNumber, customerId)
        }

        assertEquals(Constants.HANDLE_INTERNAL_SERVER_ERROR_MESSAGE, exceptionResponse.message)
    }
}