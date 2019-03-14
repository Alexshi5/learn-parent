package com.mengfei.learn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * author Alex
 * date 2019/3/12
 * description 一个关于Session的配置类
 */
@Configuration
//使用此注解设置失效时间之后，原 Spring Boot 的 server.session.timeout 属性不再生效
//maxInactiveIntervalInSeconds指明了Session的过期时间
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)
public class SessionConfig {
}
