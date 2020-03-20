package com.learn.kafaka.message;

/**
 * @author liujin
 * @datetime 2020/3/17 14:59
 */
public class Demo04Message {
    public static final String TOPIC = "DEMO_04";

    /**
     * 编号
     */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public Demo04Message setId(Integer id) {
        this.id = id;
        return this;
    }
}
