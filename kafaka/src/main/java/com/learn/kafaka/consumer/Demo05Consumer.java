package com.learn.kafaka.consumer;

import com.learn.kafaka.message.Demo05Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author liujin
 * @datetime 2020/3/17 15:23
 */
@Component
public class Demo05Consumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 我们通过 Spring EL 表达式，在每个消费者分组的名字上，使用 UUID 生成其后缀。
     * 这样，我们就能保证每个项目启动的消费者分组不同，以达到广播消费的目的。
     * @param message
     */
    @KafkaListener(topics = Demo05Message.TOPIC,
      groupId = "demo05-consumer-group-" + Demo05Message.TOPIC + "-" + "#{T(java.util.UUID).randomUUID()}",
        concurrency = "2") //如果要设置并发消费，这里设置线程数就好
    public void onMessage(Demo05Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
