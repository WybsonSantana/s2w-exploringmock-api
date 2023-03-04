package br.dev.s2w.exploring.mock.gateway.service.impl

import br.dev.s2w.exploring.mock.domain.Customer
import br.dev.s2w.exploring.mock.domain.CustomerInfoResponse
import br.dev.s2w.exploring.mock.gateway.client.GetCustomerInfoClient
import br.dev.s2w.exploring.mock.gateway.service.GetCustomerInfoService
import br.dev.s2w.exploring.mock.util.properties.ConfirmCustomerInfoProperties
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class GetCustomerInfoServiceImpl(
    private val getCustomerInfoClient: GetCustomerInfoClient,
    private val confirmCustomerInfoProperties: ConfirmCustomerInfoProperties
) : GetCustomerInfoService {

    override fun getCustomerInfo(
        authorization: String,
        documentNumber: String,
        customerId: String
    ): CustomerInfoResponse {
        if (isInvalidRequest(authorization, documentNumber, customerId)) {
            println("Requisição inválida!")
            //todo: implementar tratamento para requisição inválida
        }

        val customer = getCustomerInfoClient.requestCustomerInfo(authorization, documentNumber, customerId)

        if (isInvalidResponse(customer)) {
            println("Resposta inválida!")
            //todo: implementar tratamento para resposta inválida
        }

        val customerInfo = customer.body!!

        return buildCustomerInfoResponse(customerInfo)
    }

    private fun isInvalidRequest(authorization: String, documentNumber: String, customerId: String): Boolean {
        return authorization.isBlank()
                || documentNumber.isBlank()
                || customerId.isBlank()
    }

    private fun isInvalidResponse(customer: ResponseEntity<Customer>): Boolean {
        return customer.hasBody()
                || customer.body!!.personalInformation.fullName.isBlank()
                || customer.body!!.personalInformation.documentNumber.isBlank()
                || customer.body!!.contactInformation.emailAddress.isBlank()
    }

    private fun buildCustomerInfoResponse(customerInfo: Customer): CustomerInfoResponse {
        return CustomerInfoResponse(
            pageTitle = confirmCustomerInfoProperties.title,
            pageSubtitle = confirmCustomerInfoProperties.subtitle,
            customerName = customerInfo.personalInformation.fullName,
            customerDocumentNumber = customerInfo.personalInformation.documentNumber,
            customerEmailAddress = customerInfo.contactInformation.emailAddress,
            pageContinueButtonLabel = confirmCustomerInfoProperties.continueButtonLabel,
            pageCancelButtonLabel = confirmCustomerInfoProperties.cancelButtonLabel,
            pageWarningMessage = confirmCustomerInfoProperties.warningMessage
        )
    }
}