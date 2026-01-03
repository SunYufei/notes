package ml.sun.exchange

data class ResponseVO(
    val args: Map<String, String>,
    val data: Any?,
    val form: Map<String, String>?,
    val json: Any?,
    val origin: String
)