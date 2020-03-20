package com.learn.rocketmq.producer;

import com.learn.rocketmq.message.Demo01Message;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liujin
 * @datetime 2020/3/16 10:53
 */
@Component
public class Demo01Producer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 同步发送消息
     * @param id
     * @return
     */
    public SendResult syncSend(Integer id) {
        Demo01Message message = new Demo01Message();
        message.setId(id);
        return rocketMQTemplate.syncSend(Demo01Message.TOPIC, message);
    }

    /**
     * 异步发送消息
     * @param id
     * @param callback
     */
    public void asyncSend(Integer id, SendCallback callback) {
        Demo01Message message = new Demo01Message();
        message.setId(id);
        rocketMQTemplate.asyncSend(Demo01Message.TOPIC, message, callback);
    }

    public void onewaySend(Integer id) {
        Demo01Message message = new Demo01Message();
        message.setId(id);
        rocketMQTemplate.sendOneWay(Demo01Message.TOPIC, message);
    }
}
