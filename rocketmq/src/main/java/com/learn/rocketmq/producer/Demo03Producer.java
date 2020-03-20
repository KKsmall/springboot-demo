package com.learn.rocketmq.producer;

import com.learn.rocketmq.message.Demo03Message;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * 定时发送消息
 * @author liujin
 * @datetime 2020/3/16 14:17
 */
@Component
public class Demo03Producer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public SendResult syncSendDelay(Integer id, int delayLevel) {
        Message message = MessageBuilder.withPayload(new Demo03Message().setId(id)).build();
        return rocketMQTemplate.syncSend(Demo03Message.TOPIC, message, 30*1000, delayLevel);
    }

    public void asyncSendDelay(Integer id, int delayLevel, SendCallback callback) {
        // 创建 Demo03Message 消息
        Message message = MessageBuilder.withPayload(new Demo03Message().setId(id))
                .build();
        // 同步发送消息
        rocketMQTemplate.asyncSend(Demo03Message.TOPIC, message, callback, 30 * 1000,
                delayLevel);
    }
}
