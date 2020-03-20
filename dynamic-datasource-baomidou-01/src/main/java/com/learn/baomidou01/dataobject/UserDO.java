package com.learn.baomidou01.dataobject;

/**
 * @author liujin
 * @datetime 2020/3/10 9:26
 */
public class UserDO {
    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 账号
     */
    private String username;

    public Integer getId() {
        return id;
    }

    public UserDO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDO setUsername(String username) {
        this.username = username;
        return this;
    }
}
