package org.edu.controller;

import lombok.AllArgsConstructor;
import org.edu.dto.KafkaMessageDto;
import org.edu.service.ActionService;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/api/actions")
@RestController
public class ActionController {

    private final ActionService actionService;

    @PostMapping("/send")
    public void sendMessageToKafkaBroker(@RequestBody KafkaMessageDto kafkaMessageDto){
        actionService.send(kafkaMessageDto);
    }

}
