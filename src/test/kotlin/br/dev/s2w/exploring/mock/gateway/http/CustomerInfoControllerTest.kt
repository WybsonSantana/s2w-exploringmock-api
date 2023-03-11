package br.dev.s2w.exploring.mock.gateway.http

import br.dev.s2w.exploring.mock.util.GeneralBeans
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
internal class CustomerInfoControllerTest : GeneralBeans() {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `should return customer info confirmation when status is 200 ok`() {
        mockMvc.perform(
            MockMvcRequestBuilders.get(super.getCustomerUriIntegrationReturns200())
                .header(X_AUTHORIZATION_HEADER, super.getAuthorizationToken())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(
                MockMvcResultMatchers.content().json(
                    "{\n" +
                            "   \"page_title\": \"Confirme as suas informações\",\n" +
                            "   \"page_subtitle\": \"Por favor, verifique se os dados estão corretos\",\n" +
                            "   \"customer_name\": \"Talita Lopes Lima\",\n" +
                            "   \"customer_document_number\": \"023.021.763-08\",\n" +
                            "   \"customer_email_address\": \"talita.lopes@customer.isiflix.com.br\",\n" +
                            "   \"page_continue_button_label\": \"Continuar\",\n" +
                            "   \"page_cancel_button_label\": \"Meus dados não conferem\",\n" +
                            "   \"page_warning_message\": \"Em caso de dúvidas, entre em contato com o suporte\"\n" +
                            "}"
                )
            )
    }

    @Test
    fun `should return status 400 bad request when header missing`() {
        mockMvc.perform(
            MockMvcRequestBuilders.get(super.getCustomerUriIntegrationReturns200())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
    }

    @Test
    fun `should return 400 bad request when integration returns 400`() {
        mockMvc.perform(
            MockMvcRequestBuilders.get(super.getCustomerUriIntegrationReturns400())
                .header(X_AUTHORIZATION_HEADER, super.getAuthorizationToken())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
    }

    @Test
    fun `should return status 401 when authorization token is blank`() {
        mockMvc.perform(
            MockMvcRequestBuilders.get(super.getCustomerUriIntegrationReturns200())
                .header(X_AUTHORIZATION_HEADER, super.getBlankAuthorizationToken())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isUnauthorized)
    }

    @Test
    fun `should return status 401 unauthorized when integration returns 401`() {
        mockMvc.perform(
            MockMvcRequestBuilders.get(super.getCustomerUriIntegrationReturns401())
                .header(X_AUTHORIZATION_HEADER, super.getAuthorizationToken())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isUnauthorized)
    }

    @Test
    fun `should return status 403 forbidden when integration returns 403`() {
        mockMvc.perform(
            MockMvcRequestBuilders.get(super.getCustomerUriIntegrationReturns403())
                .header(X_AUTHORIZATION_HEADER, super.getAuthorizationToken())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isForbidden)
    }

    @Test
    fun `should return status 404 not found when uri is invalid`() {
        mockMvc.perform(
            MockMvcRequestBuilders.get(super.getInvalidUri())
                .header(X_AUTHORIZATION_HEADER, super.getAuthorizationToken())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isNotFound)
    }

    @Test
    fun `should return status 404 not found when integration returns 404`() {
        mockMvc.perform(
            MockMvcRequestBuilders.get(super.getCustomerUriIntegrationReturns404())
                .header(X_AUTHORIZATION_HEADER, super.getAuthorizationToken())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isNotFound)
    }

    @Test
    fun `should return status 500 when integration returns 500`() {
        mockMvc.perform(
            MockMvcRequestBuilders.get(super.getCustomerUriIntegrationReturns500())
                .header(X_AUTHORIZATION_HEADER, super.getAuthorizationToken())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isInternalServerError)
    }

    @Test
    fun `should return status 500 when exception handler does not mapper exception`() {
        mockMvc.perform(
            MockMvcRequestBuilders.get(super.getCustomerUriIntegrationReturns502())
                .header(X_AUTHORIZATION_HEADER, super.getAuthorizationToken())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isInternalServerError)
    }
}