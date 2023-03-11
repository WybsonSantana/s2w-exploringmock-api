package br.dev.s2w.exploring.mock.util

import br.dev.s2w.exploring.mock.domain.*
import br.dev.s2w.exploring.mock.util.properties.ConfirmCustomerInfoProperties
import org.springframework.http.ResponseEntity

open class GeneralBeans {

    val confirmCustomerInfoProperties = ConfirmCustomerInfoProperties(
        title = "Confirme as suas informações",
        subtitle = "Por favor, verifique se os dados estão corretos",
        continueButtonLabel = "Continuar",
        cancelButtonLabel = "Meus dados não conferem",
        warningMessage = "Em caso de dúvidas, entre em contato com o suporte"
    )

    fun getCustomerUriIntegrationReturns200() =
        "/customer/02302176308/identification/83014969-4800-4cc8-95eb-a2f8cd8851df"

    fun getCustomerUriIntegrationReturns400() =
        "/customer/34443942092/identification/ab9cbc88-faaf-41d4-8cf1-43e6df0139ec"

    fun getCustomerUriIntegrationReturns401() =
        "/customer/25511181072/identification/2291a061-3c0d-49a1-b3f6-08d9ca444629"

    fun getCustomerUriIntegrationReturns403() =
        "/customer/99314648010/identification/c818edcf-994f-44fc-b326-4e26470a27e0"

    fun getCustomerUriIntegrationReturns404() =
        "/customer/02738292038/identification/a7f93e8a-8a82-4707-a54b-0b84eb395d9a"

    fun getCustomerUriIntegrationReturns500() =
        "/customer/38255739076/identification/74e00e82-c129-44f9-a1de-3e7adffa03a7"

    fun getCustomerUriIntegrationReturns502() =
        "/customer/23685990020/identification/1dd22079-31dc-45f8-9b18-45587bedc615"

    fun getMessageUri() = "/message/get"

    fun getInvalidUri() = "/invalid/uri"

    fun getCustomerDTOClientResponse(): ResponseEntity<CustomerDTO> {
        val customerDTO = CustomerDTO(
            PersonalInformation(
                fullName = "Talita Lopes Lima",
                documentNumber = "023.021.763-08"
            ),
            ContactInformation(
                emailAddress = "talita.lopes@customer.isiflix.com.br"
            )
        )

        return ResponseEntity.ok(customerDTO)
    }

    fun getCustomerDTOClientResponseWithBlankAttribute(): ResponseEntity<CustomerDTO> {
        val customerDTO = CustomerDTO(
            PersonalInformation(
                fullName = "Talita Lopes Lima",
                documentNumber = ""
            ),
            ContactInformation(
                emailAddress = "talita.lopes@customer.isiflix.com.br"
            )
        )

        return ResponseEntity.ok(customerDTO)
    }

    fun getCustomerInfoResponse(): ResponseEntity<CustomerInfoResponse> {
        val customerInfoResponse = CustomerInfoResponse(
            pageTitle = "Confirme as suas informações",
            pageSubtitle = "Por favor, verifique se os dados estão corretos",
            customerName = "Talita Lopes Lima",
            customerDocumentNumber = "023.021.763-08",
            customerEmailAddress = "talita.lopes@customer.isiflix.com.br",
            pageContinueButtonLabel = "Continuar",
            pageCancelButtonLabel = "Meus dados não conferem",
            pageWarningMessage = "Em caso de dúvidas, entre em contato com o suporte"
        )

        return ResponseEntity.ok(customerInfoResponse)
    }

    fun getMessageClientResponse() = ResponseEntity.ok(Message(message = "Hello, Wiremock!"))

    fun getMessageClientResponseWithBlankAttribute() = ResponseEntity.ok(Message(message = ""))

    fun getMessage() = Message(message = "Hello, Wiremock!")

    fun getAuthorizationToken(): String {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6InMydy1leHBsb" +
                "3Jpbmdtb2NrLWFwaSIsImlhdCI6MTUxNjIzOTAyMn0.zkNVNZrzL4pG-iXj3YEYL-vd5yUV0u3HoDy8IFKtGa8"
    }

    fun getBlankAuthorizationToken() = ""

    fun getDocumentNumber() = "02302176308"

    fun getBlankDocumentNumber() = ""

    fun getCustomerId() = "83014969-4800-4cc8-95eb-a2f8cd8851df"

    fun getBlankCustomerId() = ""

    companion object {
        const val X_AUTHORIZATION_HEADER = "authorization"
    }
}