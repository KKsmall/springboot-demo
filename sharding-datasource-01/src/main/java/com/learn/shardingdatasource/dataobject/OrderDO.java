package com.learn.shardingdatasource.dataobject;

import java.io.Serializable;

/**
 * @author liujin
 * @datetime 2020/3/10 9:25
 */
public class OrderDO implements Serializable {
    /**
     * 订单编号
     */
    private Long id;
    /**
     * 用户编号
     */
    private Integer userId;

    public Long getId() {
        return id;
    }

    public OrderDO setId(Long id) {
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

    @Override
    public String toString() {
        return "OrderDO{" +
                "id=" + id +
                ", userId=" + userId +
                '}';
    }
}
