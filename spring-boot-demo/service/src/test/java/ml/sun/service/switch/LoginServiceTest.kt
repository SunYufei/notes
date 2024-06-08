package ml.sun.service.switch

import ml.sun.common.enums.ServiceSwitchKey
import ml.sun.common.result.ResultCode
import ml.sun.common.util.RedisUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class LoginServiceTest {
    @Autowired
    private lateinit var loginService: LoginService

    @Test
    fun on() {
        RedisUtil.set(ServiceSwitchKey.LOGIN_SWITCH.redisKey, "1", 60L)
        val result = loginService.doLogin()
        assertEquals(result.success, true)
        assertEquals(result.code, ResultCode.OK.code)
        assertEquals(result.message, ResultCode.OK.message)
    }

    @Test
    fun off() {
        RedisUtil.set(ServiceSwitchKey.LOGIN_SWITCH.redisKey, "0", 60L)
        val result = loginService.doLogin()
        assertEquals(result.success, false)
        assertEquals(result.code, ResultCode.LATER.code)
        assertEquals(result.message, ResultCode.LATER.message)
    }
}