package br.dev.s2w.exploring.mock.gateway.client

import br.dev.s2w.exploring.mock.domain.Customer
import br.dev.s2w.exploring.mock.util.constants.Constants.GET_CUSTOMER_INFO_CLIENT_NAME
import br.dev.s2w.exploring.mock.util.constants.Constants.X_CUSTOMER_ID
import br.dev.s2w.exploring.mock.util.constants.Constants.X_DOCUMENT_NUMBER
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = GET_CUSTOMER_INFO_CLIENT_NAME, url = "\${api.get.customer.info.client.url}")
interface GetCustomerInfoClient {

    @GetMapping("/v1/customer/consult/{document-number}/id/{customer-id}")
    fun requestCustomerInfo(
        @RequestHeader authorization: String,
        @PathVariable(X_DOCUMENT_NUMBER) documentNumber: String,
        @PathVariable(X_CUSTOMER_ID) customerId: String
    ): ResponseEntity<Customer>
}