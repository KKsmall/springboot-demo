package com.learn.rpc.dto;

import java.io.Serializable;

/**
 * @author liujin
 * @datetime 2020/3/6 13:29
 */
public class UserDTO implements Serializable {

    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 昵称
     */
    private String name;
    /**
     * 性别
     */
    private Integer gender;

    public Integer getId() {
        return id;
    }

    public UserDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public UserDTO setGender(Integer gender) {
        this.gender = gender;
        return this;
    }

}
