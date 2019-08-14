package com.github.chengzhx76.ribbon.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @desc:
 * @author: hp
 * @date: 2019/8/7
 */
@RestController
public class ServiceAController {

    @GetMapping("hello")
    public String testA() {
        return "Hello world A!";
    }

    @GetMapping("hello/{name}")
    public String testAGetName(@PathVariable String name) {
        return "GET-Hello world A!" + name;
    }

    @PostMapping("hello/{name}")
    public String testAPostName(@PathVariable String name, @RequestBody Map<String, Object> map) {
        System.out.println("A======> " + map);
        return "POST-Hello world A!" + name;
    }

}
