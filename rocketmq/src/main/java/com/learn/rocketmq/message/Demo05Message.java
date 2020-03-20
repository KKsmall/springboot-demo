package com.learn.rocketmq.message;

/**
 * @author liujin
 * @datetime 2020/3/16 14:46
 */
public class Demo05Message {

    public static final String TOPIC = "DEMO_05";

    /**
     * 编号
     */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public Demo05Message setId(Integer id) {
        this.id = id;
        return this;
    }
}
