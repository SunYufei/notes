package ml.sun.common.advice

import ml.sun.common.result.BaseResult
import org.springframework.core.MethodParameter
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice

@RestControllerAdvice
class ResponseAdvice : ResponseBodyAdvice<Any> {
    override fun supports(returnType: MethodParameter, converterType: Class<out HttpMessageConverter<*>>): Boolean {
        val method = returnType.method ?: return false
        val returnClass = method.returnType
        // BaseResult<T> 不作处理
        return !BaseResult::class.java.isAssignableFrom(returnClass)
    }

    override fun beforeBodyWrite(
        body: Any?,
        returnType: MethodParameter,
        selectedContentType: MediaType,
        selectedConverterType: Class<out HttpMessageConverter<*>>,
        request: ServerHttpRequest,
        response: ServerHttpResponse
    ): Any? = if (selectedContentType != MediaType.APPLICATION_JSON) {
        // 非 JSON 返回不作处理
        body
    } else {
        // JSON 返回包装返回
        BaseResult.success(body)
    }
}
