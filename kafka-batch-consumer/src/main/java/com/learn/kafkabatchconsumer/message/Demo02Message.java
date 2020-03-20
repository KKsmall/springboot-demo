package com.learn.kafkabatchconsumer.message;

/**
 * @author liujin
 * @datetime 2020/3/17 13:47
 */
public class Demo02Message {

    public static final String TOPIC = "DEMO_012";

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
