package com.learn.rocketmq.consumer;

import com.learn.rocketmq.message.Demo01Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 泛型类是MessageExt的一般少用，集群模式下可以多个consumer分组可以同时消费同一个topic下的消息
 * 但是同一个consumer分组下的消费者对同一个topic只有一个消费者能消费
 * 通过集群消费的机制，我们可以实现针对相同 Topic ，不同消费者分组实现各自的业务逻辑。
 * 例如说：用户注册成功时，发送一条 Topic 为 "USER_REGISTER" 的消息。
 * 然后，不同模块使用不同的消费者分组，订阅该 Topic ，实现各自的拓展逻辑：
 * 积分模块：判断如果是手机注册，给用户增加 20 积分。
 * 优惠劵模块：因为是新用户，所以发放新用户专享优惠劵。
 * 站内信模块：因为是新用户，所以发送新用户的欢迎语的站内信。
 * @author liujin
 * @datetime 2020/3/16 11:14
 */
@Component
@RocketMQMessageListener(
        topic = Demo01Message.TOPIC,
        consumerGroup = "demo01-A-consumer-group-" + Demo01Message.TOPIC
)
public class Demo01AConsumer implements RocketMQListener<MessageExt> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onMessage(MessageExt message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
