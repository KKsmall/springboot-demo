package com.learn.shardingjdbc01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Sharding-JDBC 多数据源
 * 分库分表中间件返回的 Connection 返回的实际是动态的 DynamicRoutingConnection ，
 * 它管理了整个请求（逻辑）过程中，使用的所有的 Connection ，而最终执行 SQL 的时候，
 * DynamicRoutingConnection 会解析 SQL ，获得表对应的真正的 Connection 执行 SQL 操作。
 */
@SpringBootApplication
@MapperScan(basePackages = "com.learn.shardingjdbc01.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class DynamicDatasourceShardingJdbc01Application {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDatasourceShardingJdbc01Application.class, args);
    }

}
