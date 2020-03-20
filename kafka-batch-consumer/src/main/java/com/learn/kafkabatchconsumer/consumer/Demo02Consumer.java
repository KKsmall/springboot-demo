package com.learn.kafkabatchconsumer.consumer;

import com.learn.kafkabatchconsumer.message.Demo02Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liujin
 * @datetime 2020/3/17 13:58
 */
@Component
public class Demo02Consumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 批量消费参数变成list了
     * @param message
     */
    @KafkaListener(topics = Demo02Message.TOPIC,
            groupId = "demo02-consumer-group-" + Demo02Message.TOPIC)
    public void onMessage(List<Demo02Message> message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }

}