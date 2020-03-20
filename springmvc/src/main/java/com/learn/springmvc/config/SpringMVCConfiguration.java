package com.learn.springmvc.config;

import com.learn.springmvc.interceptor.FirstInterceptor;
import com.learn.springmvc.interceptor.SecondInterceptor;
import com.learn.springmvc.interceptor.ThirdInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

/**
 * @author liujin
 * @datetime 2020/3/5 14:37
 */
@Configuration
public class SpringMVCConfiguration implements WebMvcConfigurer {

    @Bean
    public FirstInterceptor firstInterceptor() {
        return new FirstInterceptor();
    }

    @Bean
    public SecondInterceptor secondInterceptor() {
        return new SecondInterceptor();
    }

    @Bean
    public ThirdInterceptor thirdInterceptor() {
        return new ThirdInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.firstInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(this.secondInterceptor()).addPathPatterns("/users/get");
        registry.addInterceptor(this.thirdInterceptor()).addPathPatterns("/**");
    }

    /**
     * 配置跨域,这种方式遇到vue做前端开发会有问题
     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/")
//                .allowCredentials(true)
//                .allowedHeaders("*")
//                .allowedMethods("*")
//                .allowedOrigins("*")
//                .maxAge(1800L);
//    }

    public FilterRegistrationBean<CorsFilter> corsFilter() {
//      相当于创建一个注册表
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//      创建注册信息
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setAllowCredentials(true); //允许发送cookie
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.addAllowedMethod("*");
        configuration.setMaxAge(1800L);

        source.registerCorsConfiguration("/**", configuration);

        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
}
