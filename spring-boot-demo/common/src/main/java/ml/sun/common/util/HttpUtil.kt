package ml.sun.common.util

import ml.sun.common.ext.JsonExt.toJson
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import kotlin.reflect.KClass
import org.slf4j.LoggerFactory

object HttpUtil {
    private val logger = LoggerFactory.getLogger(this.javaClass)
    private val REST_TEMPLATE = SpringUtil.getBean(RestTemplate::class)

    fun get(url: String) = HttpRequest(url).method(HttpMethod.GET)

    fun post(url: String) = HttpRequest(url).method(HttpMethod.POST)

    data class HttpRequest(
        private val url: String,
        private val params: MultiValueMap<String, String> = LinkedMultiValueMap(),
        private var method: HttpMethod = HttpMethod.GET,
        private val headers: HttpHeaders = HttpHeaders(),
        private val forms: MultiValueMap<String, String> = LinkedMultiValueMap(),
        private val json: MutableMap<String, Any> = HashMap(),
        private var body: String? = null
    ) {
        fun param(name: String, vararg values: String) = apply { this.params[name] = listOf(*values) }

        fun params(params: MultiValueMap<String, String>) = apply { this.params.putAll(params) }

        fun method(method: HttpMethod) = apply { this.method = method }

        fun header(name: String, value: String) = apply { this.headers.set(name, value) }

        fun cookie(cookie: String) = header(HttpHeaders.COOKIE, cookie)

        fun contentType(contentType: String) = header(HttpHeaders.CONTENT_TYPE, contentType)

        fun form(name: String, vararg values: String) = apply {
            this.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
            this.forms[name] = listOf(*values)
        }

        fun forms(forms: MultiValueMap<String, String>) = apply {
            this.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
            this.forms.putAll(forms)
        }

        fun json(name: String, value: Any) = apply {
            this.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            this.json[name] = value
        }

        fun json(json: Any) = apply {
            this.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            this.body = if (json is String) json else json.toJson()
        }

        fun execute() = execute(String::class)

        fun <T : Any> execute(respType: KClass<T>): T? = executeForEntity(respType).body

        fun <T : Any> executeForEntity(respType: KClass<T>): ResponseEntity<T> {
            // URI
            val builder = UriComponentsBuilder.fromHttpUrl(url).queryParams(params)
            // entity
            val entity = when {
                forms.isNotEmpty() -> HttpEntity(forms, headers)
                json.isNotEmpty() -> HttpEntity(json, headers)
                else -> HttpEntity(body, headers)
            }
            // execute
            logger.debug("发起请求 {}", this)
            return REST_TEMPLATE.exchange(builder.build().toUri(), method, entity, respType.java)
        }
    }
}
