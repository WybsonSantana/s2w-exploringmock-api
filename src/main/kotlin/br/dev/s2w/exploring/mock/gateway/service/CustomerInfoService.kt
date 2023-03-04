package br.dev.s2w.exploring.mock.gateway.service

import br.dev.s2w.exploring.mock.domain.CustomerInfoResponse

interface CustomerInfoService {
    fun getCustomerInfo(authorization: String, documentNumber: String, customerId: String): CustomerInfoResponse
}