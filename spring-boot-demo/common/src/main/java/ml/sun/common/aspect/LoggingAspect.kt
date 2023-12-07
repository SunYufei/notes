package ml.sun.common.aspect

import java.time.Duration
import java.time.LocalDateTime
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class LoggingAspect {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @Pointcut(
        "within(@org.springframework.stereotype.Repository *)" +
                "|| within(@org.springframework.stereotype.Service *)" +
                "|| within(@org.springframework.web.bind.annotation.RestController *)"
    )
    fun pointcut() {
    }

    @Around("pointcut()")
    fun around(joinPoint: ProceedingJoinPoint): Any {
        val className = joinPoint.signature.declaringTypeName
        val methodName = joinPoint.signature.name
        logger.debug("进入方法 {}.{}()，参数列表 {}", className, methodName, joinPoint.args)
        val begin = LocalDateTime.now()
        val result = joinPoint.proceed()
        val end = LocalDateTime.now()
        val duration = Duration.between(begin, end).toMillis()
        logger.debug("方法结束 {}.{}()，耗时 {}ms，返回值 {}", className, methodName, duration, result)
        return result
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    fun afterThrowing(joinPoint: JoinPoint, e: Throwable) =
        logger.error(
            "产生异常 {}.{}()，异常内容 {} {}",
            joinPoint.signature.declaringTypeName,
            joinPoint.signature.name,
            e.cause,
            e.message
        )
}
