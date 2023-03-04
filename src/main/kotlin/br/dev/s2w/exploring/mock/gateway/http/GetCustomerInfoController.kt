package br.dev.s2w.exploring.mock.gateway.http

import br.dev.s2w.exploring.mock.domain.CustomerInfoResponse
import br.dev.s2w.exploring.mock.gateway.usecase.GetCustomerInfoUsecase
import br.dev.s2w.exploring.mock.util.constants.Constants.X_CUSTOMER_ID
import br.dev.s2w.exploring.mock.util.constants.Constants.X_DOCUMENT_NUMBER
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customer")
class GetCustomerInfoController(
    private val getCustomerInfoUsecase: GetCustomerInfoUsecase
) {

    @GetMapping("/{document-number}/identification/{customer-id}")
    fun getCustomerInfo(
        @RequestHeader authorization: String,
        @PathVariable(X_DOCUMENT_NUMBER) documentNumber: String,
        @PathVariable(X_CUSTOMER_ID) customerId: String
    ): CustomerInfoResponse {
        return getCustomerInfoUsecase.execute(authorization, documentNumber, customerId)
    }
}