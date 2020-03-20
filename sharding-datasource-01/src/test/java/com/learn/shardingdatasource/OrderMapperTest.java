package com.learn.shardingdatasource;

import com.learn.shardingdatasource.dataobject.OrderDO;
import com.learn.shardingdatasource.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author liujin
 * @datetime 2020/3/10 14:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingDatasource01Application.class)
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testSelectById() {
//      因为分片是按userId来的 这里用Id只能全库全表查询
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
    }

    @Test
    public void testSelectListByUserId() {
        List<OrderDO> orders = orderMapper.selectListByUserId(1);
        System.out.println(orders.size());
    }

    @Test
    public void testInsert() {
        OrderDO order = new OrderDO();
//      插入时也要带上分片字段 不然不知道插入哪个表
        order.setUserId(1);
        orderMapper.insert(order);
    }
}
