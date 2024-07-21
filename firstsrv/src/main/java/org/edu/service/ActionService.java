package org.edu.service;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.edu.dto.KafkaMessageDto;
import org.edu.entity.KafkaMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ActionService {

    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;
    private final NewTopic topic;

    public void send(KafkaMessageDto kafkaMessageDto){

        KafkaMessage kafkaMessage = new KafkaMessage(kafkaMessageDto.getTitle(), kafkaMessageDto.getDataCount());

        kafkaTemplate.send(topic.name(), kafkaMessage)
                .whenComplete((result, ex)-> {
                    if(ex == null){
                        //код по необходимости
                    } else {
                        //можно записать лог
                        //также можно отправить сообщение снова или другим способом
                    }
                        });
    }
}
