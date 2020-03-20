package com.learn.kafkatransaction.message;

/**
 * @author liujin
 * @datetime 2020/3/17 16:00
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
