package com.github.chengzhx76.kafka.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.chengzhx76.kafka.demo.producer.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @desc:
 * @author: hp
 * @date: 2019/8/7
 */

@RestController
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("send/{topic}")
    public void producer(@PathVariable String topic, @RequestBody JSONObject msg){
        producerService.doSend(topic, msg);
    }


    @GetMapping("test")
    public void test() throws InterruptedException {
        TimeUnit.MINUTES.sleep(5);
    }

    @PostMapping("rest")
    public void rest(){
        restTemplate.getForEntity("", String.class);
    }
}
