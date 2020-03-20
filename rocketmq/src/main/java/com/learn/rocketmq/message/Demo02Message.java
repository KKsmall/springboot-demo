package com.learn.rocketmq.message;

/**
 * @author liujin
 * @datetime 2020/3/16 13:51
 */
public class Demo02Message {

    public static final String TOPIC = "DEMO_02";

    /**
     * 编号
     */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public Demo02Message setId(Integer id) {
        this.id = id;
        return this;
    }
}
