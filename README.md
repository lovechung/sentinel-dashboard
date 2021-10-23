# 修改记录
### 源项目地址：[sentinel](https://github.com/alibaba/Sentinel) 

- pom 加入以下依赖：

```xml
<dependency>
    <groupId>com.alibaba.csp</groupId>
    <artifactId>sentinel-datasource-redis</artifactId>
    <version>1.8.2</version>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
    <version>${spring.boot.version}</version>
</dependency>
```

- DashboardConfig 加入自定义的配置

- 目录 `com.alibaba.csp.sentinel.dashboard.rule` 下增加三个文件：

    - FlowRuleRedisProvider
    - FlowRuleRedisPublisher
    - RedisConfig

- 前端文件已修改

- maven 打包

- docker 镜像打包