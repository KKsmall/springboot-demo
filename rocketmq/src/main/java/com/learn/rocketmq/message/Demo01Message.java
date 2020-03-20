package com.learn.rocketmq.message;

/**
 * @author liujin
 * @datetime 2020/3/16 10:51
 */
public class Demo01Message {

    public static final String TOPIC = "DEMO_01";

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
