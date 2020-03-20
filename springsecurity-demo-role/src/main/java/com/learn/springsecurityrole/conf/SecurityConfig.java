package com.learn.springsecurityrole.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * @author liujin
 * @datetime 2020/3/11 9:33
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth //真实项目中一般实现自定义的UserDetailsService 来实现认证用户信息的读取，参考艿艿博客若依的项目
//               使用内存中的管理器
                .inMemoryAuthentication()
//               这里不使用密码编码器，其实等于不设置但是不写会报错
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("admin").password("admin").roles("ADMIN")
                .and().withUser("normal").password("normal").roles("NORMAL");
    }

    /**
     * 配置url的权限控制
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/test/echo").permitAll() //所有用户可以访问
                .antMatchers("/test/admin").hasRole("ADMIN")
                .antMatchers("/test/normal").access("hasRole('ROLE_NORMAL')")
                .and()
                .formLogin()
//                    .loginPage("/login") 可以跳转自定义页面
                    .permitAll()
                .and()
                .logout()
//                    .logoutUrl("/logout") 可以跳转自定义页面
                    .permitAll();
    }
}
