package com.learn.baomidou01;

import com.learn.baomidou01.dataobject.OrderDO;
import com.learn.baomidou01.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liujin
 * @datetime 2020/3/10 9:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DynamicDatasourceBaomidou01Application.class)
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testSelectById() {
        OrderDO orderDO = orderMapper.selectById(1);
        System.out.println(orderDO);
    }
}
