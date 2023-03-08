package br.dev.s2w.exploring.mock.gateway.usecase

import br.dev.s2w.exploring.mock.domain.CustomerInfoResponse
import br.dev.s2w.exploring.mock.gateway.service.CustomerInfoService
import br.dev.s2w.exploring.mock.util.validation.headerInputValidation
import org.springframework.stereotype.Component

@Component
class CustomerInfoUsecase(
    private val customerInfoService: CustomerInfoService
) {

    fun execute(
        authorization: String,
        documentNumber: String,
        customerId: String
    ): CustomerInfoResponse {
        headerInputValidation(authorization)

        return customerInfoService.getCustomerInfo(authorization, documentNumber, customerId)
    }
}