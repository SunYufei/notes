package ml.sun.common.annotation

import ml.sun.common.enums.ServiceSwitchKey
import ml.sun.common.result.ResultCode

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class ServiceSwitch(
    /**
     * 业务开关
     */
    val key: ServiceSwitchKey,
    /**
     * 提示信息
     */
    val code: ResultCode = ResultCode.LATER
)
