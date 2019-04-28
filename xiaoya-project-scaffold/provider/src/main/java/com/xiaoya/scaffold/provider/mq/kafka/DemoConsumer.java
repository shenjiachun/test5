package com.xiaoya.scaffold.provider.mq.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: zhuzhongji
 * @Date: 2019/4/9 23:13
 */
@Component
public class DemoConsumer {

//    @KafkaListener(topics = "test_topic")
    public void listen (ConsumerRecord<?, ?> record) throws Exception {
        System.out.printf("topic = %s, value = %s \n", record.topic(), record.value());
    }
}
