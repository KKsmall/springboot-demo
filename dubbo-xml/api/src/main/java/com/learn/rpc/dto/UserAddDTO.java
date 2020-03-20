package com.learn.rpc.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author liujin
 * @datetime 2020/3/6 13:29
 */
public class UserAddDTO implements Serializable {

    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 昵称
     */
    @NotEmpty(message = "昵称不能为空")
    @Length(min = 5, max = 16, message = "账号长度为 5-16 位")
    private String name;
    /**
     * 性别
     */
    @NotNull(message = "性别不能为空")
    private Integer gender;

    public Integer getId() {
        return id;
    }

    public UserAddDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserAddDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public UserAddDTO setGender(Integer gender) {
        this.gender = gender;
        return this;
    }

}
