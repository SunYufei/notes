package ml.sun.common.ext

import org.slf4j.Logger
import org.slf4j.LoggerFactory

object LogExt {
    inline val <reified T> T.logger: Logger
        get() = LoggerFactory.getLogger(T::class.java)
}
