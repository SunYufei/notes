package ml.sun.common.result

enum class ResultCode(val code: Int, val message: String) {
    OK(0, ""),
    ILLEGAL_ARGS(400, "非法参数"),
    EXCEPTION(500, "抛出异常"),
    LATER(500, "请稍后重试")
}
