package com.learn.springmvc.web;

import com.learn.springmvc.vo.CommonResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 拦截指定controller接口返回的结果，包装成统一格式
 * @author liujin
 * @datetime 2020/3/5 13:51
 */
@ControllerAdvice(basePackages = "com.learn.springmvc.controller")
public class GlobalResponseBodyHandler implements ResponseBodyAdvice { //这里对响应做拦截 同样可以对请求做拦截RequestBodyAdvice
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true; //表示拦截controller所有api返回的结果
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (body instanceof CommonResult) {
            return body;
        }
        return CommonResult.success(body);
    }
}
