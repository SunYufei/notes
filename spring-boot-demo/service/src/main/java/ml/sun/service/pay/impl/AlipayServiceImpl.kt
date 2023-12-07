package ml.sun.service.pay.impl

import ml.sun.service.pay.IPayService
import ml.sun.service.pay.PayStrategy
import ml.sun.service.pay.enums.PayTemplate
import ml.sun.service.pay.vo.OrderInfoVO
import ml.sun.service.pay.vo.PayVO
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Service

@Service
class AlipayServiceImpl : IPayService, InitializingBean {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    override fun afterPropertiesSet() {
        PayStrategy.register(PayTemplate.ALIPAY, this)
    }

    override fun pay(orderInfo: OrderInfoVO): PayVO {
        logger.info("AlipayService")
        return PayVO(orderInfo)
    }
}