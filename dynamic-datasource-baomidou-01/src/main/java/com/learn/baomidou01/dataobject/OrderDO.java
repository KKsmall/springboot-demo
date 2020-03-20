package com.learn.baomidou01.dataobject;

/**
 * @author liujin
 * @datetime 2020/3/10 9:25
 */
public class OrderDO {
    /**
     * 订单编号
     */
    private Integer id;
    /**
     * 用户编号
     */
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public OrderDO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public OrderDO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }
}
