package com.learn.rocketmq.message;

/**
 * @author liujin
 * @datetime 2020/3/16 16:08
 */
public class Demo07Message {

    public static final String TOPIC = "DEMO_07";

    /**
     * 编号
     */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public Demo07Message setId(Integer id) {
        this.id = id;
        return this;
    }
}
