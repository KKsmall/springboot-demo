package com.learn.springsecurityrole;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * security 授权，即某个请求路径需要某个权限才可访问
 */
@SpringBootApplication
public class SpringsecurityDemoRoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityDemoRoleApplication.class, args);
    }

}
