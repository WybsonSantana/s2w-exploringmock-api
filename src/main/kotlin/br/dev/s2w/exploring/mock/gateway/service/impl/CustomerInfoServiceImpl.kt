package br.dev.s2w.exploring.mock.gateway.service.impl

import br.dev.s2w.exploring.mock.domain.CustomerDTO
import br.dev.s2w.exploring.mock.domain.CustomerInfoResponse
import br.dev.s2w.exploring.mock.exception.InvalidRequestException
import br.dev.s2w.exploring.mock.exception.InvalidResponseException
import br.dev.s2w.exploring.mock.gateway.client.CustomerInfoClient
import br.dev.s2w.exploring.mock.gateway.service.CustomerInfoService
import br.dev.s2w.exploring.mock.util.constants.Constants
import br.dev.s2w.exploring.mock.util.logger.logDebug
import br.dev.s2w.exploring.mock.util.properties.ConfirmCustomerInfoProperties
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CustomerInfoServiceImpl(
    private val customerInfoClient: CustomerInfoClient,
    private val confirmCustomerInfoProperties: ConfirmCustomerInfoProperties
) : CustomerInfoService {

    private val logger: Logger = LoggerFactory.getLogger(CustomerInfoServiceImpl::class.java)

    override fun getCustomerInfo(
        authorization: String,
        documentNumber: String,
        customerId: String
    ): CustomerInfoResponse {
        logDebug(logger, "Starting service to request customer information... customer_id: $customerId")

        if (isInvalidRequest(authorization, documentNumber, customerId)) {
            throw InvalidRequestException(Constants.HANDLE_BAD_REQUEST_MESSAGE)
        }


        val customerDTO = customerInfoClient.requestCustomerInfo(authorization, documentNumber, customerId)

        if (isInvalidResponse(customerDTO)) {
            throw InvalidResponseException(Constants.HANDLE_INTERNAL_SERVER_ERROR_MESSAGE)
        }

        val customerInfo = customerDTO.body!!

        return buildCustomerInfoResponse(customerInfo).also {
            logDebug(logger, "Finished service to request customer information. customer_id: $customerId")
        }
    }

    private fun isInvalidRequest(authorization: String, documentNumber: String, customerId: String): Boolean {
        return authorization.isBlank()
                || documentNumber.isBlank()
                || customerId.isBlank()
    }

    private fun isInvalidResponse(customer: ResponseEntity<CustomerDTO>): Boolean {
        return !customer.hasBody()
                || customer.body!!.personalInformation.fullName.isBlank()
                || customer.body!!.personalInformation.documentNumber.isBlank()
                || customer.body!!.contactInformation.emailAddress.isBlank()
    }

    private fun buildCustomerInfoResponse(customerDTOInfo: CustomerDTO): CustomerInfoResponse {
        return CustomerInfoResponse(
            pageTitle = confirmCustomerInfoProperties.title,
            pageSubtitle = confirmCustomerInfoProperties.subtitle,
            customerName = customerDTOInfo.personalInformation.fullName,
            customerDocumentNumber = customerDTOInfo.personalInformation.documentNumber,
            customerEmailAddress = customerDTOInfo.contactInformation.emailAddress,
            pageContinueButtonLabel = confirmCustomerInfoProperties.continueButtonLabel,
            pageCancelButtonLabel = confirmCustomerInfoProperties.cancelButtonLabel,
            pageWarningMessage = confirmCustomerInfoProperties.warningMessage
        )
    }
}