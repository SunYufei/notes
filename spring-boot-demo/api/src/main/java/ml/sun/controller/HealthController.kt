package ml.sun.controller

import ml.sun.common.result.BaseResult
import ml.sun.common.result.ResultCode
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
}
