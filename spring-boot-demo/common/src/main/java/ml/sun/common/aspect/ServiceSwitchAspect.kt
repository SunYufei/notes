package ml.sun.common.aspect

import ml.sun.common.annotation.ServiceSwitch
import ml.sun.common.result.BaseResult
import ml.sun.common.util.RedisUtil
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature
import org.springframework.stereotype.Component

@Aspect
@Component
class ServiceSwitchAspect {
    @Pointcut("@annotation(ml.sun.common.annotation.ServiceSwitch)")
    fun pointcut() {
    }

    @Around("pointcut()")
    fun around(joinPoint: ProceedingJoinPoint): Any {
        // 被代理方法参数
        val args = joinPoint.args
        // 被代理对象
        val target = joinPoint.target
        // 通知签名
        val signature = joinPoint.signature as MethodSignature
        // 被代理方法
        val method = target.javaClass.getMethod(signature.name, *signature.parameterTypes)
        // 被代理方法注解
        val annotation = method.getAnnotation(ServiceSwitch::class.java)
        // 核心业务逻辑
        if (annotation != null) {
            val key = annotation.key
            val code = annotation.code
            val config = RedisUtil.get(key.redisKey)
            if ("0" == config) {
                // 开关关闭，则返回提示
                return BaseResult.failure(code, null)
            }
        }
        // 放行
        return joinPoint.proceed(args)
    }
}
