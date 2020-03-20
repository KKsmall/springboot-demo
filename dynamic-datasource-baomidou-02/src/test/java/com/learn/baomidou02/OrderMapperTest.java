package com.learn.baomidou02;

import com.learn.baomidou02.dataobject.OrderDO;
import com.learn.baomidou02.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liujin
 * @datetime 2020/3/10 10:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DynamicDatasourceBaomidou02Application.class)
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testSelectById() {
        for (int i = 0; i < 10; i++) {
            OrderDO order = orderMapper.selectById(1);
            System.out.println(order);
        }
    }

    @Test
    public void testInsert() {
        OrderDO order = new OrderDO();
        order.setUserId(5);
        order.setId(1);
        orderMapper.insert(order);
    }
}
