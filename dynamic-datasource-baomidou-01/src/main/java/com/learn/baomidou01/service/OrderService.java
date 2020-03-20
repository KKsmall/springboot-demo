package com.learn.baomidou01.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.learn.baomidou01.constant.DBConstants;
import com.learn.baomidou01.dataobject.OrderDO;
import com.learn.baomidou01.dataobject.UserDO;
import com.learn.baomidou01.mapper.OrderMapper;
import com.learn.baomidou01.mapper.UserMapper;
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
    //总的来说，对于声明了 @Transactional 的 Service 方法上，也同时通过 @DS 声明对应的数据源
//    此时orderMapper的@DS没什么用
    @DS(DBConstants.DATASOURCE_ORDERS)
    public void method041() {
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
    }

    @Transactional
    @DS(DBConstants.DATASOURCE_USERS)
    public void method042() {
        UserDO user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Transactional
    @DS(DBConstants.DATASOURCE_ORDERS)
    public void method05() {
        // 查询订单
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
        // 查询用户
        self().method052();
    }

    //method05调用该方法也不会有问题，因为Propagation.REQUIRES_NEW会暂时性的将原事务和
    //当前线程解绑，然后这边执行完后再恢复。不用这个事务传播级别的话就会报Table 'test_orders.users' doesn't exist错误
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @DS(DBConstants.DATASOURCE_USERS)
    public void method052() {
        UserDO user = userMapper.selectById(1);
        System.out.println(user);
    }
}
