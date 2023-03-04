package br.dev.s2w.exploring.mock.gateway.usecase

import br.dev.s2w.exploring.mock.domain.CustomerInfoResponse
import br.dev.s2w.exploring.mock.gateway.service.GetCustomerInfoService
import org.springframework.stereotype.Component

@Component
class GetCustomerInfoUsecase(
    private val getCustomerInfoService: GetCustomerInfoService
) {

    fun execute(
        authorization: String,
        documentNumber: String,
        customerId: String
    ): CustomerInfoResponse {
        return getCustomerInfoService.getCustomerInfo(authorization, documentNumber, customerId)
    }
}