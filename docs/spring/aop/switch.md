# AOP 接口访问控制

当需要临时关闭某个接口访问权限时，可通过注解与 AOP 结合的方式进行控制

访问权限配置方法

1. Redis
2. 数据库
3. 数据字典

### 注解

<<<@/../spring-boot-demo/common/src/main/java/ml/sun/common/annotation/ServiceSwitch.kt

<<<@/../spring-boot-demo/common/src/main/java/ml/sun/common/enums/ServiceSwitchKey.kt

<<<@/../spring-boot-demo/common/src/main/java/ml/sun/common/result/ResultCode.kt

### AOP

<<<@/../spring-boot-demo/common/src/main/java/ml/sun/common/aspect/ServiceSwitchAspect.kt

### 使用

<<<@/../spring-boot-demo/service/src/main/java/ml/sun/service/switch/LoginService.kt
