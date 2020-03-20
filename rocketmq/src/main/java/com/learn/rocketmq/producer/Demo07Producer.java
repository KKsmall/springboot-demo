package com.learn.rocketmq.producer;

import com.learn.rocketmq.message.Demo07Message;
import com.sun.xml.internal.txw2.TxwException;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**事务消息
 * @author liujin
 * @datetime 2020/3/16 16:09
 */
@Component
public class Demo07Producer {

    private static final String TX_PRODUCER_GROUP = "demo07-producer-group";

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public TransactionSendResult sendMessageInTransaction(Integer id) {
        Message message = MessageBuilder.withPayload(new Demo07Message().setId(id)).build();

//      发送事务小时
        return rocketMQTemplate.sendMessageInTransaction(TX_PRODUCER_GROUP, Demo07Message.TOPIC, message, id);
    }

    /**
     * 创建一个内部类 TransactionListenerImpl ，实现 MQ 事务的监听
     */
    @RocketMQTransactionListener(txProducerGroup = TX_PRODUCER_GROUP)
    public class TransactionListernerImpl implements RocketMQLocalTransactionListener {

        private Logger logger = LoggerFactory.getLogger(getClass());

        /**
         * 执行本地事务后为非commit状态，之后mq会在checkLocalTransaction方法中回查producer消息是否提交成功，成功的话就修改事务为提交
         * 然后消费者再消费
         * @param message
         * @param arg
         * @return
         */
        @Override
        public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object arg) {
            // ... local transaction process, return rollback, commit or unknown
            logger.info("[executeLocalTransaction][执行本地事务，消息：{} arg：{}]", message, arg);
            return RocketMQLocalTransactionState.UNKNOWN;
        }

        @Override
        public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
            // ... check transaction status and return rollback, commit or unknown
            logger.info("[checkLocalTransaction][回查消息：{}]", message);
            return RocketMQLocalTransactionState.COMMIT;
        }
    }
}
