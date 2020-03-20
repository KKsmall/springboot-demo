package com.learn.kafaka.producer;

import com.learn.kafaka.message.Demo01Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

/**
 * @author liujin
 * @datetime 2020/3/17 10:00
 */
@Component
public class Demo01Producer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public SendResult syncSend(Integer id) throws ExecutionException, InterruptedException {
        Demo01Message message = new Demo01Message();
        message.setId(id);
//      同步发送内部其实也是调用异步方法，只是调用了返回值ListenableFuture的get方法 阻塞获取了
        return (SendResult) kafkaTemplate.send(Demo01Message.TOPIC, message).get();
    }

    public ListenableFuture<SendResult<Object, Object>> asyncSend(Integer id) {
        Demo01Message message = new Demo01Message();
        message.setId(id);
//      异步发送消息
        return kafkaTemplate.send(Demo01Message.TOPIC, message);
    }
}
