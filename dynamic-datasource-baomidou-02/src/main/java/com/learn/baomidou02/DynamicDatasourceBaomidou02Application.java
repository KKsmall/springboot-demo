package com.learn.baomidou02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 读写分离，其实也是多数据源的一部分
 */
@SpringBootApplication
@MapperScan(basePackages = "com.learn.baomidou02.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class DynamicDatasourceBaomidou02Application {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDatasourceBaomidou02Application.class, args);
    }

}
