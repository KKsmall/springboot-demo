package com.learn.shardingjdbc02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Sharding-JDBC 读写分离
 */
@SpringBootApplication
@MapperScan(basePackages = "com.learn.shardingjdbc02.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class DynamicDatasourceShardingJdbc02Application {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDatasourceShardingJdbc02Application.class, args);
    }

}
