package com.learn.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 使用 RocketMQ-Spring 封装提供的 RocketMQTemplate ，实现三种发送消息的方式
 */
@SpringBootApplication
public class RocketmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketmqApplication.class, args);
    }

}
