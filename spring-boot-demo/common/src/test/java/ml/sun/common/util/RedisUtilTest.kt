package ml.sun.common.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("common")
class RedisUtilTest {
    @Test
    fun key() {
        val key = "KEY"
        val value = "VALUE"
        assertFalse(RedisUtil.hasKey(key))
        RedisUtil.set(key, value)
        assertEquals(RedisUtil.get(key), value)
        assertEquals(RedisUtil.getExpire(key), -1)
        assertTrue(RedisUtil.expire(key, 60))
        assertNotEquals(RedisUtil.getExpire(key), -1)
        assertTrue(RedisUtil.delete(key))
    }

    @Test
    fun json() {
        data class Test(val name: String, val value: String)

        val key = "JSON_KEY"
        val value = Test("name", "value")

        RedisUtil.set(key, value)
        assertEquals(RedisUtil.get(key, Test::class), value)
        RedisUtil.delete(key)
    }

    @Test
    fun bitMap() {
        val key = "BITMAP_KEY"
        longArrayOf(10, 100, 1000, 10000).forEach { offset ->
            assertFalse(RedisUtil.getBit(key, offset))
            RedisUtil.setBit(key, offset, true)
            assertTrue(RedisUtil.getBit(key, offset))
        }
        RedisUtil.delete(key)
    }
}