package ml.sun.service.pay

import ml.sun.service.pay.vo.OrderInfoVO
import ml.sun.service.pay.vo.PayVO

interface IPayService {
    fun pay(orderInfo: OrderInfoVO): PayVO {
        throw RuntimeException("支付业务未支持 $orderInfo")
    }
}