package ml.sun.common.advice

import ml.sun.common.result.BaseResult
import ml.sun.common.result.ResultCode
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionAdvice {
    @ExceptionHandler(Exception::class)
    fun handler(e: Exception) = BaseResult.failure(ResultCode.EXCEPTION, e.message)

    @ExceptionHandler(IllegalArgumentException::class)
    fun illegalArgsHandler(e: IllegalArgumentException) = BaseResult.failure(ResultCode.ILLEGAL_ARGS, e.message)
}
