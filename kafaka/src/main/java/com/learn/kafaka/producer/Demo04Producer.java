package com.learn.kafaka.producer;

import com.learn.kafaka.message.Demo04Message;
import com.learn.kafaka.message.Demo06Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

/**
 * @author liujin
 * @datetime 2020/3/17 15:00
 */
@Component
public class Demo04Producer {

    @Resource
    private KafkaTemplate<Object, Object> kafkaTemplate;

    public SendResult syncSend(Integer id) throws ExecutionException, InterruptedException {
        // 创建 Demo04Message 消息
        Demo04Message message = new Demo04Message();
        message.setId(id);
        // 同步发送消息
        return kafkaTemplate.send(Demo04Message.TOPIC, message).get();
    }

    public SendResult syncSendOrderly(Integer id) throws ExecutionException, InterruptedException {
        // 创建 Demo01Message 消息
        Demo06Message message = new Demo06Message();
        message.setId(id);
        // 同步发送消息
        // 因为我们使用 String 的方式序列化 key ，所以需要将 id 转换成 String
//        我们多传入了 id 作为消息的 key ，从而实现发送到 DEMO_06 这个 Topic 下的相同 Partition 中,
//        天然就支持按照 Topic 下的 Partition 下的消息，顺序消费
        return kafkaTemplate.send(Demo06Message.TOPIC, String.valueOf(id), message).get();
    }
}