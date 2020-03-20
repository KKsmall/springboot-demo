package com.learn.sentinellimit.conf;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.SentinelWebInterceptor;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.SentinelWebTotalInterceptor;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.config.SentinelWebMvcConfig;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.config.SentinelWebMvcTotalConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liujin
 * @datetime 2020/3/20 15:01
 */
@Configuration
public class SpringMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        addSentinelWebInterceptor(registry);
    }

    private void addSentinelWebInterceptor(InterceptorRegistry registry) {
        SentinelWebMvcConfig sentinelWebMvcConfig = new SentinelWebMvcConfig();
        sentinelWebMvcConfig.setHttpMethodSpecify(true);// <1.2> 是否包含请求方法。即基于 URL 创建的资源，是否包含 Method。
        // config.setBlockExceptionHandler(new DefaultBlockExceptionHandler()); // <1.3> 设置 BlockException 处理器。Sentinel 在流量控制时，当请求到达阀值后，会抛出 BlockException 异常。此时，可以通过定义 BlockExceptionHandler 去处理。这里，我们使用 SpringMVC 提供的全局异常处理机制

        registry.addInterceptor(new SentinelWebInterceptor(sentinelWebMvcConfig)).addPathPatterns("/**");
    }

    private void addSentinelWebTotalInterceptor(InterceptorRegistry registry) {
        SentinelWebMvcTotalConfig sentinelWebMvcTotalConfig = new SentinelWebMvcTotalConfig();

        registry.addInterceptor(new SentinelWebTotalInterceptor(sentinelWebMvcTotalConfig)).addPathPatterns("/**");
    }
}
