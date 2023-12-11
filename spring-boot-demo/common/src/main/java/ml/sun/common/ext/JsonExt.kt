package ml.sun.common.ext

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import ml.sun.common.util.SpringUtil
import kotlin.reflect.KClass

object JsonExt {
    private val mapper = SpringUtil.getBean(ObjectMapper::class)

    init {
        //  Kotlin 支持
        mapper.registerKotlinModule()
        // 如果为空则不输出
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY)
        // 对于空的对象转 Json 的时候不抛出错误
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
        // 禁用序列化日期为 Timestamp
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        // 禁用遇到未知属性抛出异常
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    }

    fun Any.toJson(): String = if (this is String) this else mapper.writeValueAsString(this)

    fun String.toObj(): JsonNode = mapper.readTree(this)

    fun <T : Any> String.toObj(toValueType: KClass<T>): T = mapper.readValue(this, toValueType.java)

    fun <T : Any> JsonNode.asObj(toValueType: KClass<T>): T = mapper.convertValue(this, toValueType.java)

    fun <E : Any> String.toList(elementType: KClass<E>): List<E> =
        mapper.readerForListOf(elementType.java).readValue(this)

    fun <E : Any> JsonNode.asList(elementType: KClass<E>): List<E> =
        mapper.readerForListOf(elementType.java).readValue(this)

    fun <E : Any> JsonNode.getList(fieldName: String, elementType: KClass<E>): List<E> =
        this.get(fieldName).asList(elementType)

    fun <V : Any> String.toMap(valueType: KClass<V>): Map<String, V> =
        mapper.readerForMapOf(valueType.java).readValue(this)

    fun <V : Any> JsonNode.asMap(valueType: KClass<V>): Map<String, V> =
        mapper.readerForMapOf(valueType.java).readValue(this)

    fun <V : Any> JsonNode.getMap(fieldName: String, valueType: KClass<V>): Map<String, V> =
        this.get(fieldName).asMap(valueType)

    fun JsonNode.getText(fieldName: String): String = this.get(fieldName).asText()

    fun JsonNode.getBoolean(fieldName: String): Boolean = this.get(fieldName).asBoolean()
}
