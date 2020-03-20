package com.learn.kafkatransaction.producer;

import com.learn.kafkatransaction.message.Demo07Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

/**事务消息
 * 如果 Kafka Producer 开启了事务的功能，则所有发送的消息，都必须处于 Kafka 事务之中，
 * 否则会抛出 " No transaction is in process; possible solutions: run the template operation within the scope of a template.executeInTransaction() operation, start a transaction with @Transactional before invoking the template method, run in a transaction started by a listener container when consuming a record" 异常。
 *
 * 所以，如果胖友的业务中，即存在需要事务的情况，也存在不需要事务的情况，需要分别定义两个 KafkaTemplate（Kafka Producer）。
 *
 * 还有一种集成到 Spring Transaction 体系具体看下https://www.jianshu.com/p/59891ede5f90
 * @author liujin
 * @datetime 2020/3/17 16:35
 */
@Component
public class Demo07Producer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public String syncSendInTransaction(Integer id, Runnable runnable) {
        return (String) kafkaTemplate.executeInTransaction(new KafkaOperations.OperationsCallback<Object, Object,String>() {
            @Override
            public String doInOperations(KafkaOperations kafkaOperations) {
                Demo07Message message = new Demo07Message();
                message.setId(id);

                try {
                    SendResult<Object, Object> sendResult = (SendResult<Object, Object>) kafkaOperations.send(Demo07Message.TOPIC, message).get();
                    logger.info("[doInOperations][发送编号：[{}] 发送结果：[{}]]", id, sendResult);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

//              这里可以执行本地业务逻辑 用runnable代替一下
                runnable.run();
                return "success";
            }
        });
    }
}
