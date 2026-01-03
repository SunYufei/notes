package ml.sun.exchange

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient
import org.springframework.web.client.support.RestClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
class HttpBinClientConfig {
    @Bean
    fun client(builder: RestClient.Builder): HttpBinClient {
        val client = builder.baseUrl("https://httpbin.org").build()
        val adapter = RestClientAdapter.create(client)
        return HttpServiceProxyFactory.builderFor(adapter).build().createClient(HttpBinClient::class.java)
    }
}