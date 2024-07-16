package org.edu.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ActionService {


    @KafkaListener(topics = "First_Microservice", groupId = "first")
    public void messagePull(String message){
        System.out.println("Received message = " + message);
    }

}
