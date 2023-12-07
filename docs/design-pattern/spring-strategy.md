# Spring 中的策略模式

利用 Spring 中的 InitializingBean 接口，在 Bean 初始化时将 Bean 注册至工厂类中

## 工厂类

<<< @/../spring-boot-demo/service/src/main/java/ml/sun/service/pay/PayStrategy.kt

## 工厂方法及实现

<<< @/../spring-boot-demo/service/src/main/java/ml/sun/service/pay/IPayService.kt

<<< @/../spring-boot-demo/service/src/main/java/ml/sun/service/pay/impl/CashServiceImpl.kt

## 调用方法

<<< @/../spring-boot-demo/service/src/test/java/ml/sun/service/pay/PayServiceTest.kt
