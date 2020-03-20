package com.learn.kafkabatch;

import com.learn.kafkabatch.producer.Demo02Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.CountDownLatch;

/**
 * @author liujin
 * @datetime 2020/3/17 13:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaBatchApplication.class)
public class Demo02ProducerTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Demo02Producer demo02Producer;

    @Test
    public void testAsyncSend() throws InterruptedException {
        logger.info("[testASyncSend][开始执行]");

        for (int i = 0; i < 3; i++) {
            int id = (int) (System.currentTimeMillis() / 1000);

            demo02Producer.aysncSend(id).addCallback(new ListenableFutureCallback<SendResult<Object, Object>>() {
                @Override
                public void onFailure(Throwable throwable) {
                    logger.info("[testASyncSend][发送编号：[{}] 发送异常]]", id, throwable);
                }

                @Override
                public void onSuccess(SendResult<Object, Object> objectObjectSendResult) {
                    logger.info("[testASyncSend][发送编号：[{}] 发送成功，结果为：[{}]]", id, objectObjectSendResult);
                }
            });

            Thread.sleep(10 * 1000L);
        }

        new CountDownLatch(1).await();
    }
}
