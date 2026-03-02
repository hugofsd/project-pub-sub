package com.kafka.exemple.ms.ms_pub.controller;

import com.kafka.exemple.ms.ms_pub.service.PubService;
import com.kafka.exemple.ms.ms_pub.model.JsonMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pub")
public class PubController {

    @Autowired
    private PubService pubService;

    @PostMapping("/text")
	public void publishText(@RequestBody JsonMessage message){
		System.out.println("Request received:" + message);
		pubService.send(message);
    }

    @GetMapping
    public String get(){
        System.out.println("Request received");
        return "ok";
    }

}
