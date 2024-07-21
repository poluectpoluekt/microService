package org.edu.service;

import lombok.AllArgsConstructor;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.edu.entity.KafkaMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ActionService {

    private Logger logger = LoggerFactory.getLogger(ActionService.class);

    Map<Long, KafkaMessage> bucketMessageByKafka = new HashMap<>();

    private List<KafkaMessage> kafkaMessageList = new ArrayList<>();

    @KafkaListener(topics = "First_Microservice", groupId = "main_group_consumer")
    public void messagePull(@Payload KafkaMessage message, @Header(KafkaHeaders.OFFSET) Long offset){
        bucketMessageByKafka.put(offset, message);
        kafkaMessageList.add(message);
    }

    public List<KafkaMessage> getListMessagesByKafka(){
        return kafkaMessageList;
    }

    public Map<Long, KafkaMessage> getMapByKafka(){
        return bucketMessageByKafka;
    }

}
