package com.learn.springmvc.controller;

import com.learn.springmvc.constants.ServiceExceptionEnum;
import com.learn.springmvc.exception.ServiceException;
import com.learn.springmvc.vo.CommonResult;
import com.learn.springmvc.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author liujin
 * @datetime 2020/3/5 13:55
 */
@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * 获得指定用户编号的用户
     *
     * 提供不使用 CommonResult 包装
     *
     * @param id 用户编号
     * @return 用户
     */
    @GetMapping("/get")
    public UserVO get(@RequestParam("id") Integer id) {
        // 查询并返回用户
        return new UserVO().setId(id).setUsername(UUID.randomUUID().toString());
    }

    /**
     * 获得指定用户编号的用户
     *
     * 提供使用 CommonResult 包装
     *
     * @param id 用户编号
     * @return 用户
     */
    @GetMapping("/get2")
    public CommonResult<UserVO> get2(@RequestParam("id") Integer id) {
        // 查询用户
        UserVO user = new UserVO().setId(id).setUsername(UUID.randomUUID().toString());
        // 返回结果
        return CommonResult.success(user);
    }

    /**
     * 测试抛出 NullPointerException 异常
     */
    @GetMapping("/exception1")
    public UserVO exception01() {
        throw new NullPointerException("没有粗面鱼丸");
    }

    /**
     * 测试抛出 ServiceException 异常
     */
    @GetMapping("/exception2")
    public UserVO exception02() {
        throw new ServiceException(ServiceExceptionEnum.USER_NOT_FOUND);
    }

    @GetMapping("/do_something")
    public void doSomething() {
        System.out.println("dosomething");
    }

}
