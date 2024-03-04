package ml.sun.service.mall

import ml.sun.common.util.RedisUtil
import ml.sun.service.mall.vo.SecKillVO
import org.slf4j.LoggerFactory
import org.springframework.data.redis.core.script.DefaultRedisScript
import org.springframework.stereotype.Service

@Service
class SellService {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    private val luaScript = DefaultRedisScript(
        """
            if redis.call('exists', KEYS[2]) == 0 then
                redis.call('sadd', KEYS[2], '-1')
            end
            
            if tonumber(redis.call('get', KEYS[1])) > 0 and redis.call('sismember', KEYS[2], ARGV[1]) == 0 then
                redis.call('incrby', KEYS[1], '-1')
                redis.call('sadd', KEYS[2], ARGV[1])
                return true
            else
                return false
            end
        """.trimIndent(),
        Boolean::class.java
    )

    fun secKill(productId: String, userId: String): SecKillVO {
        // KEYS
        val keys = listOf("P$productId", "U$productId")
        // 执行 lua 脚本
        val vo = SecKillVO(productId, userId)
        vo.success = RedisUtil.TEMPLATE.execute(luaScript, keys, userId)
        logger.info("执行秒杀活动 {}", vo)
        // 返回执行结果
        return vo
    }
}