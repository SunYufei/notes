package ml.sun.service.pay.vo

import ml.sun.service.pay.enums.PayTemplate

data class OrderInfoVO(val template: PayTemplate, val orderNo: String, val userId: String)