package com.learn.kafaka.message;

/**
 * @author liujin
 * @datetime 2020/3/17 16:00
 */
public class Demo06Message {

    public static final String TOPIC = "DEMO_06";

    /**
     * 编号
     */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public Demo06Message setId(Integer id) {
        this.id = id;
        return this;
    }
}
