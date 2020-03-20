package com.learn.flyway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Flyway 提供了 SQL-based migrations 和 Java-based migrations 两种数据库变更方式。
 *
 * 前者使用简单，无需编写 Java 代码。
 * 后者需要使用 Java 编写代码，胜在灵活。
 * 一般情况下，如果是做表的变更，或者记录的简单插入、更新、删除等操作，使用 SQL-based migrations 即可。
 *
 * 复杂场景下，我们可能需要关联多个表，则需要通过编写 Java 代码，进行逻辑处理，此时就是和使用 Java-based migrations 了。
 */
@SpringBootApplication
public class FlywayApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlywayApplication.class, args);
    }

}
