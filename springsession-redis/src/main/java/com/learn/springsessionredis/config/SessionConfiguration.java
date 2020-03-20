package com.learn.springsessionredis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author liujin
 * @datetime 2020/3/5 16:09
 */
@Configuration
@EnableRedisHttpSession //开启自动化配置 Spring Session 使用 Redis 作为数据源,该注解还有一些属性具体看博客
public class SessionConfiguration {


    @Bean(name = "springSessionDefaultRedisSerializer")
    public RedisSerializer springSessionDefaultRedisSerializer() {
        return RedisSerializer.json();
    }
}
