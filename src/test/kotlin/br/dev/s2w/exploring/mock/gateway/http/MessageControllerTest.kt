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
internal class MessageControllerTest : GeneralBeans() {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `should return a message when status is 200 ok`() {
        mockMvc.perform(
            MockMvcRequestBuilders.get(super.getMessageUri())
                .header(X_AUTHORIZATION_HEADER, super.getAuthorizationToken())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(
                MockMvcResultMatchers.content().json(
                    "{\n" +
                            "    \"message\": \"Hello, Wiremock!\"\n" +
                            "}"
                )
            )
    }

    @Test
    fun `should return status 400 bad request when header missing`() {
        mockMvc.perform(
            MockMvcRequestBuilders.get(super.getMessageUri())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
    }

    @Test
    fun `should return status 401 when authorization token is blank`() {
        mockMvc.perform(
            MockMvcRequestBuilders.get(super.getMessageUri())
                .header(X_AUTHORIZATION_HEADER, super.getBlankAuthorizationToken())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isUnauthorized)
    }

    @Test
    fun `should return 404 not found when uri is invalid`() {
        mockMvc.perform(
            MockMvcRequestBuilders.get(super.getInvalidUri())
                .header(X_AUTHORIZATION_HEADER, super.getAuthorizationToken())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isNotFound)
    }
}