package ml.sun.common.enums

enum class ServiceSwitchKey(val redisKey: String) {
    /**
     * 注册开关
     */
    LOGIN_SWITCH("service:switch:login")
}