package com.learn.rocketmq.message;

/**
 * @author liujin
 * @datetime 2020/3/16 14:15
 */
public class Demo03Message {

    public static final String TOPIC = "DEMO_03";

    /**
     * 编号
     */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public Demo03Message setId(Integer id) {
        this.id = id;
        return this;
    }
}