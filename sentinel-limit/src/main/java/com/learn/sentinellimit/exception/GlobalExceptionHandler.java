package com.learn.sentinellimit.exception;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author liujin
 * @datetime 2020/3/20 15:11
 */
@ControllerAdvice(basePackages = "com.learn.sentinellimit.controller")
public class GlobalExceptionHandler {

    public String blockExceptionHandler(BlockException blockException) {
        return "请求过于频繁";
    }
}
