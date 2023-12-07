package ml.sun.service.pay

import ml.sun.service.pay.enums.PayTemplate
import java.util.concurrent.ConcurrentHashMap

object PayStrategy {
    private val map: MutableMap<PayTemplate, IPayService> = ConcurrentHashMap()

    fun getService(template: PayTemplate) = map[template]

    fun register(template: PayTemplate, service: IPayService) {
        map[template] = service
    }
}