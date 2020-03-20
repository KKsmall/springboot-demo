package com.learn.kafkabatch.producer;

import com.learn.kafkabatch.message.Demo02Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;

/**
 * @author liujin
 * @datetime 2020/3/17 13:48
 */
@Component
public class Demo02Producer {

    @Resource
    private KafkaTemplate<Object, Object> kafkaTemplate;

    /**
     * 配置文件配置的批量发送的，kafka会自己收集，当满足相应条件时批量发送，这里发送代码还是跟之前的方式一样
     * @param id
     * @return
     */
    public ListenableFuture<SendResult<Object, Object>> aysncSend(Integer id) {
        Demo02Message message = new Demo02Message();
        message.setId(id);

        //异步发送
        return kafkaTemplate.send(Demo02Message.TOPIC, message);
    }
}
