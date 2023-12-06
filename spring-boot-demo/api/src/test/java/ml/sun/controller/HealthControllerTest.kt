package ml.sun.controller

import ml.sun.common.result.ResultCode
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(HealthController::class)
class HealthControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun health() {
        mockMvc.get("/health").andExpect {
            status { isOk() }
            jsonPath("$.data") { doesNotExist() }
        }.andDo { print() }

        mockMvc.get("/health?param=test").andExpect {
            status { isOk() }
            jsonPath("$.data") { value("test") }
        }.andDo { print() }
    }

    @Test
    fun error() {
        mockMvc.get("/health/error").andExpect {
            status { isOk() }
            jsonPath("$.success") { value(false) }
            jsonPath("$.code") { value(ResultCode.EXCEPTION.code) }
            jsonPath("$.message") { value(ResultCode.EXCEPTION.message) }
        }.andDo { print() }
    }

    @Test
    fun body() {
        mockMvc.get("/health/body?code=100").andExpect {
            status { isOk() }
            jsonPath("$.data") { value(100) }
        }.andDo { print() }

        mockMvc.get("/health/html").andExpect {
            status { isOk() }
            content { contentType("${MediaType.TEXT_HTML_VALUE};charset=UTF-8") }
        }.andDo { print() }
    }
}
