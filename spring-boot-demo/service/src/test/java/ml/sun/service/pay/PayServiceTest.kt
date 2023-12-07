package ml.sun.service.pay

import ml.sun.service.pay.enums.PayTemplate
import ml.sun.service.pay.impl.AlipayServiceImpl
import ml.sun.service.pay.impl.CashServiceImpl
import ml.sun.service.pay.impl.TencentServiceImpl
import ml.sun.service.pay.vo.OrderInfoVO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig

@SpringJUnitConfig(AlipayServiceImpl::class, CashServiceImpl::class, TencentServiceImpl::class)
class PayServiceTest {
    @Test
    fun test() {
        // 测试样例
        val orderList = listOf(
            OrderInfoVO(PayTemplate.ALIPAY, "", ""),
            OrderInfoVO(PayTemplate.CASH, "", ""),
            OrderInfoVO(PayTemplate.TENCENT, "", "")
        )
        // 逐条测试
        orderList.forEach { order ->
            val pay = PayStrategy.getService(order.template)?.pay(order)
            assertEquals(pay?.template, order.template)
        }
    }
}