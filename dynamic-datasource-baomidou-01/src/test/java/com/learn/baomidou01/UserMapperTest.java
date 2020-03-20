package com.learn.baomidou01;

import com.learn.baomidou01.dataobject.UserDO;
import com.learn.baomidou01.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liujin
 * @datetime 2020/3/10 9:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DynamicDatasourceBaomidou01Application.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectById() {
        UserDO user = userMapper.selectById(1);
        System.out.println(user);
    }
}
