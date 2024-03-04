package ml.sun.service.mall

import ml.sun.service.mall.vo.SecKillVO

interface ISellService {
    fun secKill(productId: String, userId: String): SecKillVO
}