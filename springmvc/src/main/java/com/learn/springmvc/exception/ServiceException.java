package com.learn.springmvc.exception;

import com.learn.springmvc.constants.ServiceExceptionEnum;

/**
 * @author liujin
 * @datetime 2020/3/5 14:11
 */
public final class ServiceException extends RuntimeException {

    private final Integer code;

    public ServiceException(ServiceExceptionEnum serviceExceptionEnum) {
        super(serviceExceptionEnum.getMessage());
        this.code = serviceExceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
