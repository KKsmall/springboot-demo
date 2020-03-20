package com.learn.kafaka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ConsumerRecordRecoverer;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.util.backoff.BackOff;
import org.springframework.util.backoff.FixedBackOff;

/**
 * kafka没有消息重试功能，spring-kafka封装了这个，通过拦截异常做处理
 * @author liujin
 * @datetime 2020/3/17 14:48
 */
@Configuration
public class KafkaConfiguration {

    @Bean
    @Primary
    public ErrorHandler kafkaErrorHandler(KafkaTemplate<Object, Object> template) {

//      创建 DeadLetterPublishingRecoverer 对象，
//      它负责实现，在重试到达最大次数时，Consumer 还是消费失败时，该消息就会发送到死信队列
        ConsumerRecordRecoverer recordRecoverer = new DeadLetterPublishingRecoverer(template);

//      创建 FixedBackOff 对象。这里，我们配置了重试 3 次，每次固定间隔 10 秒。
//      当然，胖友可以选择 BackOff 的另一个子类 ExponentialBackOff 实现，提供指数递增的间隔时间。
        BackOff backOff = new FixedBackOff(10 * 1000L, 3L);

//      创建 SeekToCurrentErrorHandler 对象，负责处理异常，串联整个消费重试的整个过程。
//      SeekToCurrentErrorHandler是对单条消息做重试，多条SeekToCurrentBatchErrorHandler
        return new SeekToCurrentErrorHandler(recordRecoverer, backOff);
    }
}
