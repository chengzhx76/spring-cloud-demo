package com.github.chengzhx76.kafka.demo.consumer;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ConsumerService {

    private final static Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(id = "cheng_id", containerFactory = "kafkaListenerContainerFactory",
            topics = "cheng_topic_a", errorHandler = "consumerAwareErrorHandler")
    public void consumer(List<ConsumerRecord<Integer, String>> records,
                                      Acknowledgment ack,
                                      Consumer<Integer, String> consumer) {
        ConsumerRecord<Integer, String> rd = null;
        for ( ConsumerRecord<Integer, String> record : records) {
            logger.info("handler consumer topic={},partition={},offset={},value={}",
                    record.topic(), record.partition(), record.offset(), record.value());
            rd = record;
        }

        ack.acknowledge();

//        if (rd != null) {
//            consumer.seek(new TopicPartition("cheng_topic_a", rd.partition()), rd.offset());
//        }

    }

}




