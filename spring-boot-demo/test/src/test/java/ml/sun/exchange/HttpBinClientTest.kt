package ml.sun.exchange

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class HttpBinClientTest {
    @Autowired
    private lateinit var client: HttpBinClient

    @Test
    fun method() {
        assertEquals(client.get("value").args["key"], "value")
        assertNull(client.post().json)
    }
}