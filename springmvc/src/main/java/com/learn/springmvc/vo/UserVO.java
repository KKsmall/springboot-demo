package com.learn.springmvc.vo;

/**
 * @author liujin
 * @datetime 2020/3/5 13:55
 */
public class UserVO {

    public Integer id;
    private String userName;

    public Integer getId() {
        return id;
    }

    public UserVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return userName;
    }

    public UserVO setUsername(String userName) {
        this.userName = userName;
        return this;
    }
}
