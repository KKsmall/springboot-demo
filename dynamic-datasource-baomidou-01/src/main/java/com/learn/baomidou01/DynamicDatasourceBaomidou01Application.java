package com.learn.baomidou01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 基于 Spring AbstractRoutingDataSource 做多数据源拓展。
 * 比较好的是 baomidou 提供的 dynamic-datasource-spring-boot-starter
 */
@SpringBootApplication
@MapperScan(basePackages = "com.learn.baomidou01.mapper")
@EnableAspectJAutoProxy(exposeProxy = true) //我们希望 Spring AOP 能将当前代理对象设置到 AopContext 中 用来后续处理事务
public class DynamicDatasourceBaomidou01Application {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDatasourceBaomidou01Application.class, args);
    }

}
