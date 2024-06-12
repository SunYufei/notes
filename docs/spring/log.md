# 日志文件

将日志信息输出至指定目录，可根据运行环境进行分别配置

```yml
logging:
   charset:
      console: UTF-8
      file: UTF-8
   file:
      name: log/${profileActive:dev}.log
   level:
      ml.sun: debug
   threshold:
      console: info
      file: debug
```

也可分别配置 console 和 file 的输出级别（logging.threshold）

若 SpringBoot 版本低，则可通过 logback-spring.xml 进行配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
   <include resource="org/springframework/boot/logging/logback/defaults.xml"/>
   <include resource="org/springframework/boot/logging/logback/file-appender.xml"/>

   <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
		<encoder>
			<pattern>${CONSOLE_LOG_PATTERN}</pattern>
			<charset>${CONSOLE_LOG_CHARSET}</charset>
		</encoder>
      <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
			<level>info</level>
		</filter>
	</appender>
</configuration>
```
