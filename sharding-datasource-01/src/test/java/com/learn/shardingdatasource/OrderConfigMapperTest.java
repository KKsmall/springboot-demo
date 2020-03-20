package com.learn.shardingdatasource;

import com.learn.shardingdatasource.dataobject.OrderConfigDO;
import com.learn.shardingdatasource.mapper.OrderConfigMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liujin
 * @datetime 2020/3/10 14:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingDatasource01Application.class)
public class OrderConfigMapperTest {

    @Autowired
    private OrderConfigMapper orderConfigMapper;

    @Test
    public void testSelectById() {
        OrderConfigDO orderConfig = orderConfigMapper.selectById(1);
        System.out.println(orderConfig);
    }
}
