package com.learn.rocketmq.producer;

import com.learn.rocketmq.message.Demo02Message;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 批量发送消息
 * @author liujin
 * @datetime 2020/3/16 13:51
 */
@Component
public class Demo02Producer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public SendResult sendBatch(Collection<Integer> ids) {
        List<Message<Demo02Message>> messages = new ArrayList<>(ids.size());
        for (Integer id : ids) {
            Demo02Message message = new Demo02Message().setId(id);
            messages.add(MessageBuilder.withPayload(message).build());
        }

        return rocketMQTemplate.syncSend(Demo02Message.TOPIC, messages, 30*1000L);
    }
}
