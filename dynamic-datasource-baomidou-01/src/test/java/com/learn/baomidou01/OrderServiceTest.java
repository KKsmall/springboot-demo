package com.learn.baomidou01;

import com.learn.baomidou01.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liujin
 * @datetime 2020/3/10 10:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DynamicDatasourceBaomidou01Application.class)
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void test() {
        orderService.method05();
    }
}
