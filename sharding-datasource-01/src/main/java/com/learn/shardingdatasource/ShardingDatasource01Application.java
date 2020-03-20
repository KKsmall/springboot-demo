package com.learn.shardingdatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.learn.shardingdatasource.mapper")
public class ShardingDatasource01Application {

    public static void main(String[] args) {
        SpringApplication.run(ShardingDatasource01Application.class, args);
    }

}
