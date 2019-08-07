package com.github.chengzhx76.ribbon.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @desc:
 * @author: hp
 * @date: 2019/8/7
 */
@Service
public class CustomerService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod="helloFallBack")
    public String helloService(){
        return restTemplate.getForObject("http://test-service/hello", String.class);
    }

    public String helloFallBack(){
        return "Error occurred!";
    }

}
