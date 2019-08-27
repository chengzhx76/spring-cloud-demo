package com.github.chengzhx76.kafka.demo.producer;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;


/**
 * @desc:
 * @author: hp
 * @date: 2019/8/26
 */
@Service
public class ProducerService {

    private final static Logger logger = LoggerFactory.getLogger(ProducerService.class);

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate ;

    public void doSend(String topic, JSONObject data){
        try {
            ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(topic, data.toString());
            SendResult<Integer, String> result = future.get();
            RecordMetadata metadata = result.getRecordMetadata();
            logger.debug("send message sync success:topic={},partition={},offset={},value={}",
                    metadata.topic(), metadata.partition(), metadata.offset(), data.toString());
        } catch (Exception e) {
            logger.error("send message sync failed :topic={},value={}", topic, data.toString(), e);
        }
    }
}
