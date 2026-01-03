package ml.sun.exchange

import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.PostExchange

interface HttpBinClient {
    @GetExchange("/get")
    fun get(@RequestParam key: String): ResponseVO

    @PostExchange("/post")
    fun post(): ResponseVO
}