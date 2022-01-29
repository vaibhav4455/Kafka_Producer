package com.moglix.kafka.kafka.resource;

import com.moglix.kafka.kafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResource {
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
    private static final String Topic="quickstart-events";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name){
        kafkaTemplate.send(Topic,new User(name,"technology",120000L));
        return "published successfully";
    }


}
