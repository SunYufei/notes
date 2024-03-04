package ml.sun.common.util

import ml.sun.common.ext.JsonExt.toJson
import ml.sun.common.ext.JsonExt.toObj
import org.springframework.data.redis.core.StringRedisTemplate
import java.util.concurrent.TimeUnit
import kotlin.reflect.KClass

object RedisUtil {
    val TEMPLATE = SpringUtil.getBean(StringRedisTemplate::class)

    fun hasKey(key: String): Boolean =
        TEMPLATE.hasKey(key)

    fun getExpire(key: String): Long =
        TEMPLATE.getExpire(key)

    fun expire(key: String, seconds: Long): Boolean =
        TEMPLATE.expire(key, seconds, TimeUnit.SECONDS)

    fun get(key: String): String? =
        TEMPLATE.opsForValue().get(key)

    fun <T : Any> get(key: String, toValueType: KClass<T>): T? =
        get(key)?.toObj(toValueType)

    fun getBit(key: String, offset: Long): Boolean =
        TEMPLATE.opsForValue().getBit(key, offset) == true

    fun <T : Any> set(key: String, value: T, seconds: Long = -1) = run {
        TEMPLATE.opsForValue().set(key, value.toJson())
        if (seconds > 0) expire(key, seconds) else true
    }

    fun setBit(key: String, offset: Long, value: Boolean): Boolean? =
        TEMPLATE.opsForValue().setBit(key, offset, value)

    fun delete(key: String): Boolean =
        TEMPLATE.delete(key)
}