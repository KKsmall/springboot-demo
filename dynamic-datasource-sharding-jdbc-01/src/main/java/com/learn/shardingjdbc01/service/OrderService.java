package com.learn.shardingjdbc01.service;

import com.learn.shardingjdbc01.dataobject.OrderDO;
import com.learn.shardingjdbc01.dataobject.UserDO;
import com.learn.shardingjdbc01.mapper.OrderMapper;
import com.learn.shardingjdbc01.mapper.UserMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**用5个示例展示集成基于spring的多数据源下存在的事务问题
 * @author liujin
 * @datetime 2020/3/10 9:50
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;

    private OrderService self() {
//      启动入口的注解，将当前代理对象设置到AopContext，该类的话就是代理OrderService
//      因为spring事务是基于aop实现的，如果是new OrderService的话无法触发aop
        return (OrderService) AopContext.currentProxy();
    }

    //此时没有使用@Transactional 注解，不会开启事务
    public void method01() {
        // 查询订单
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
        // 查询用户
        UserDO user = userMapper.selectById(1);
        System.out.println(user);
    }

    /**
     * 此时会报Table 'test_users.orders' doesn't exist异常
     * 虽然orderMapper和userMapper都指定了自己的数据源，但是因为使用了@Transactional注解
     * 他相关的代码就会通过aop拦截到此方法，然后去创建事务，创建事务势必会获得数据源，并且会把创建的事务
     * 绑定到当前线程中。创建事务也就意味着包含Connection连接，也就是说再还没执行orderMapper查询的时候
     * 连接已被创建，orderMapper查询获得的连接就是线程绑定的connection,而该连接在配置中primary: users默认配置的就是users数据源
     * 所以就报那个错误了
     */
    @Transactional
    public void method02() {
        // 查询订单
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
        // 查询用户
        UserDO user = userMapper.selectById(1);
        System.out.println(user);
    }

    public void method03() {
        // 查询订单
        self().method031();
        // 查询用户
        self().method032(); //这种方式等价method02

        //这种方式等价method01,因为用this的话并没有经过代理对象，所以@Transactional注解并没有生效
        this.method031();
        // 查询用户
        this.method032();
    }

    @Transactional
    public void method031() {
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
    }

    @Transactional
    public void method032() {
        UserDO user = userMapper.selectById(1);
        System.out.println(user);
    }

    public void method04() {
        // 查询订单
        self().method041();
        // 查询用户
        self().method042();
    }

    @Transactional
    public void method041() {
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
    }

    @Transactional
    public void method042() {
        UserDO user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Transactional
    public void method05() {
        // 查询订单
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
        // 查询用户
        self().method052();
    }

    //因为用分库分表中间件的多数据源，它创建的connection是动态的，它管理了整个逻辑过程的connection
    //它会在解析sql的时候动态获取真正的connection,所以上面调用这个方法，该方法不用设置事务传播等级来挂起
    //当前线程
    @Transactional
    public void method052() {
        UserDO user = userMapper.selectById(1);
        System.out.println(user);
    }
}
