package br.dev.s2w.exploring.mock.gateway.client

import br.dev.s2w.exploring.mock.domain.CustomerDTO
import br.dev.s2w.exploring.mock.util.constants.Constants
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = Constants.GET_CUSTOMER_INFO_CLIENT_NAME, url = "\${api.get.customer.info.client.url}")
interface CustomerInfoClient {

    @GetMapping("/v1/mock/customer/consult/{document-number}/id/{customer-id}")
    fun requestCustomerInfo(
        @RequestHeader authorization: String,
        @PathVariable(Constants.X_DOCUMENT_NUMBER) documentNumber: String,
        @PathVariable(Constants.X_CUSTOMER_ID) customerId: String
    ): ResponseEntity<CustomerDTO>
}