package ml.sun.service.mall

import java.util.concurrent.CountDownLatch
import java.util.concurrent.CyclicBarrier
import java.util.concurrent.Executors
import ml.sun.common.util.RedisUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("service")
class SellServiceTest {
    @Autowired
    private lateinit var sellService: SellService

    @Test
    fun secKill() {
        val productId = "1010"
        val productCount = 10
        val redisKey = "P$productId"
        RedisUtil.set(redisKey, productCount.toString())

        val threads = 50
        val pool = Executors.newFixedThreadPool(threads)
        val barrier = CyclicBarrier(threads)
        val countDownLatch = CountDownLatch(threads)

        val successList = mutableListOf<String>()

        class Task(private val productId: String, private val userId: String) : Runnable {
            override fun run() {
                barrier.await()
                val vo = sellService.secKill(this.productId, this.userId)
                if (vo.success == true) {
                    successList.add(vo.userId)
                }
                countDownLatch.countDown()
            }
        }

        for (i in 0 until threads) {
            pool.submit(Task(productId, i.toString()))
        }
        countDownLatch.await()

        RedisUtil.delete(redisKey)

        assertEquals(successList.size, productCount)
        assertEquals(successList.size, successList.toSet().size)

        RedisUtil.delete("U$productId")
    }
}