package ml.sun.common.util

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import ml.sun.common.ext.JsonExt.getText
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import org.springframework.web.client.RestTemplate

@SpringJUnitConfig(SpringUtil::class, ObjectMapper::class, RestTemplate::class)
class HttpUtilTest {
    @Test
    fun test() {
        val json = HttpUtil.get("http://httpbin.org/get").execute(JsonNode::class)
        val origin = json?.getText("origin") ?: ""
        Assertions.assertTrue {
            Regex("\\d+.\\d+.\\d+.\\d+").matches(origin)
        }
    }
}
