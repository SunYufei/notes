package ml.sun.common.result

class BaseResult<T> private constructor(val success: Boolean, val code: Int, val message: String, val data: T) {
    companion object {
        fun <T> success(data: T) = success(ResultCode.OK, data)

        fun <T> success(code: ResultCode, data: T) = BaseResult(true, code.code, code.message, data)

        fun <T> failure(code: ResultCode, data: T) = BaseResult(false, code.code, code.message, data)
    }
}
