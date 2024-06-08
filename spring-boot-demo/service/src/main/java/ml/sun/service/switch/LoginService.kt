package ml.sun.service.switch

import ml.sun.common.annotation.ServiceSwitch
import ml.sun.common.enums.ServiceSwitchKey.LOGIN_SWITCH
import ml.sun.common.result.BaseResult
import ml.sun.common.result.ResultCode
import org.springframework.stereotype.Service

@Service
class LoginService {
    @ServiceSwitch(key = LOGIN_SWITCH, code = ResultCode.LATER)
    fun doLogin() = BaseResult.success(null)
}