package com.learn.shardingjdbc02.service;

import com.learn.shardingjdbc02.dataobject.OrderDO;
import com.learn.shardingjdbc02.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liujin
 * @datetime 2020/3/10 14:09
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    public void add(OrderDO order) {
        // <1.1> 这里先假模假样的读取一下。读取从库
        OrderDO exists = orderMapper.selectById(1);
        System.out.println(exists);

        // <1.2> 插入订单
        orderMapper.insert(order);

        //!!!!在 Sharding-JDBC 中，读写分离约定：
        // 同一线程且同一数据库连接内，如有写入操作，以后的读操作均从主库读取，用于保证数据一致性。
        exists = orderMapper.selectById(1);
        System.out.println(exists);
    }

    public OrderDO findById(Integer id) {
        return orderMapper.selectById(id);
    }
}
