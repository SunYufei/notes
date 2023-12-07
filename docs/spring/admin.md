# Spring Boot Admin

### 服务端配置

pom.xml

```xml
<dependencies>
   <dependency>
      <groupId>de.codecentric</groupId>
      <artifactId>spring-boot-admin-starter-server</artifactId>
      <version>2.6.2</version>
   </dependency>
</dependencies>
```

AdminApplication.java

```java
package ml.sun.sba;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
```

application.yml

> 若非同机部署，可忽略配置端口

```yaml
server:
   port: 9001
```

### 客户端配置

pom.xml 中添加如下依赖

```xml
<dependency>
   <groupId>de.codecentric</groupId>
   <artifactId>spring-boot-admin-starter-client</artifactId>
   <version>2.6.2</version>
</dependency>
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

application.yml 中配置 spring-boot-admin 及监控启用内容

```yaml
spring:
   boot:
      admin:
         client:
            url: http://localhost:9001

management:
   endpoints:
      web:
         exposure:
            include: '*'
```
