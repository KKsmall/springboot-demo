package com.learn.shardingdatasource.dataobject;

/**
 * @author liujin
 * @datetime 2020/3/10 14:48
 */
public class OrderConfigDO {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 支付超时时间
     *
     * 单位：分钟
     */
    private Integer payTimeout;

    public Integer getId() {
        return id;
    }

    public OrderConfigDO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getPayTimeout() {
        return payTimeout;
    }

    public OrderConfigDO setPayTimeout(Integer payTimeout) {
        this.payTimeout = payTimeout;
        return this;
    }
}
