package com.learn.sessionspringsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 去掉了自定义的 JSON RedisSerializer Bean 的配置。原因是，HttpSession 的 attributes 属性，是 Map<String, Object> 类型。
 * 在序列化 Session 到 Redis 中时，不存在问题。
 * 在反序列化 Redis 的 key-value 键值对成 Session 时，
 * 如果 attributes 的 value 存在 POJO 对象的时候，因为不知道该 value 是什么 POJO 对象，导致无法反序列化错误。
 * @author liujin
 * @datetime 2020/3/6 10:43
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfiguration {
}
