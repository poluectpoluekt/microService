package org.edu.controller;

import lombok.AllArgsConstructor;
import org.edu.entity.KafkaMessage;
import org.edu.service.ActionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RequestMapping("/api/actions")
@RestController
public class ActionController {

    private final ActionService actionService;

    @GetMapping("/map")
    public Map<Long, KafkaMessage> kafkaMessageMap(){
        return actionService.getMapByKafka();
    }

}