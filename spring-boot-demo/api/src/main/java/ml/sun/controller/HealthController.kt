package ml.sun.controller

import ml.sun.common.result.BaseResult
import ml.sun.common.result.ResultCode
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("health")
class HealthController {
    @GetMapping
    fun health(@RequestParam(required = false) param: String?) =
        if (param.isNullOrBlank())
            BaseResult.failure(ResultCode.ILLEGAL_ARGS, param)
        else
            BaseResult.success(param)

    @GetMapping("error")
    fun error() {
        throw ArithmeticException()
    }

    @GetMapping("body")
    fun body(@RequestParam code: Int) = code

    @GetMapping(path = ["html"], produces = [MediaType.TEXT_HTML_VALUE])
    fun html() = "<html><header><title>HTML</title></header><body><h1>H1</h1></body></html>"
}
