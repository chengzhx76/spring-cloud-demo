package com.github.chengzhx76.ribbon.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: hp
 * @date: 2019/8/7
 */

@RestController
public class ServiceBController {
    @GetMapping("hello")
    public String testA(){
        return "Hello world B!";
    }
}
