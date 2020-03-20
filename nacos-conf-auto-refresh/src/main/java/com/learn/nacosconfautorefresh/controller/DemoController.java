package com.learn.nacosconfautorefresh.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.learn.nacosconfautorefresh.property.TestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liujin
 * @datetime 2020/3/19 15:48
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

//    @Value("${test}")
    @NacosValue(value = "${test}", autoRefreshed = true)
    private String test;

    @GetMapping("/test")
    public String test() {
        return test;
    }

    @Autowired
    private TestProperties testProperties;

//  这里测试@NacosConfigurationProperties配置的自动刷新是否生效
    @GetMapping("/test_properties")
    public TestProperties testProperties() {
        return testProperties;
    }
}
