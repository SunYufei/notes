# 异常处理

## lombok @SneakyThrows

lombok 的 `@SneakyThrows` 可将异常传递给上层，可通过 `lombok.config` 文件配置异常抛出类型

```properties
lombok.nonNull.exceptionType = NullPointerException
```

1. NullPointerException（默认）

   抛出 NPE，异常信息为 `[fieldName] is marked non-null but is null`

2. IllegalArgumentException

   抛出 IllegalArgumentException，异常信息同 NPE

3. JDK

   调用 `Objects.requireNonNull(fieldName, "[fieldName] is marked non-null but is null")`

4. Guava

   调用 `com.google.common.base.Preconditions.checkNotNull(fieldName, [fieldName] is marked non-null but is null")`

5. Assertion

   调用 `Assert.notNull(fieldName, "[fieldName] is marked non-null but is null")`

同样地，配置日志级别

```properties
lombok.nonNull.flagUsage = [warning | error] (默认: 未设置)
```

## 全局异常处理

<<< @/../spring-boot-demo/common/src/main/java/ml/sun/common/advice/ExceptionAdvice.kt
