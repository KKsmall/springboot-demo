package com.learn.kafaka.message;

/**
 * @author liujin
 * @datetime 2020/3/17 15:24
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
