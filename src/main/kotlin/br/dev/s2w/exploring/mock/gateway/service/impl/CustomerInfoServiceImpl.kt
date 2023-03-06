package br.dev.s2w.exploring.mock.gateway.service.impl

import br.dev.s2w.exploring.mock.domain.CustomerDTO
import br.dev.s2w.exploring.mock.domain.CustomerInfoResponse
import br.dev.s2w.exploring.mock.gateway.client.CustomerInfoClient
import br.dev.s2w.exploring.mock.gateway.service.CustomerInfoService
import br.dev.s2w.exploring.mock.util.properties.ConfirmCustomerInfoProperties
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CustomerInfoServiceImpl(
    private val customerInfoClient: CustomerInfoClient,
    private val confirmCustomerInfoProperties: ConfirmCustomerInfoProperties
) : CustomerInfoService {

    override fun getCustomerInfo(
        authorization: String,
        documentNumber: String,
        customerId: String
    ): CustomerInfoResponse {
        if (isInvalidRequest(authorization, documentNumber, customerId)) {
            println("Requisição inválida!")
            //todo: implementar tratamento para requisição inválida
        }

        val customerDTO = customerInfoClient.requestCustomerInfo(authorization, documentNumber, customerId)

        if (isInvalidResponse(customerDTO)) {
            println("Resposta inválida!")
            //todo: implementar tratamento para resposta inválida
        }

        val customerInfo = customerDTO.body!!

        return buildCustomerInfoResponse(customerInfo)
    }

    private fun isInvalidRequest(authorization: String, documentNumber: String, customerId: String): Boolean {
        return authorization.isBlank()
                || documentNumber.isBlank()
                || customerId.isBlank()
    }

    private fun isInvalidResponse(customer: ResponseEntity<CustomerDTO>): Boolean {
        return customer.hasBody()
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