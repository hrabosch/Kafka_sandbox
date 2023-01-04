package org.hrabosch.kafka.kafkaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private InputListener inputListener;

    @Autowired
    public KafkaController(InputListener inputListener) {
        this.inputListener = inputListener;
    }

    @GetMapping(value = "/latest", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getReceivedMessages() {
        return inputListener.getLastMessage();
    }
}
