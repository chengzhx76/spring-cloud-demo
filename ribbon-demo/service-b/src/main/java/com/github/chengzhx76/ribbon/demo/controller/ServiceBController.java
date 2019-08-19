package com.github.chengzhx76.ribbon.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @desc:
 * @author: hp
 * @date: 2019/8/7
 */

@RestController
public class ServiceBController {

    @GetMapping("hello")
    public String test() {
        return "Hello world B!";
    }

    @GetMapping("hello/{name}")
    public String testGetName(@PathVariable String name) {
        return "GET-Hello world B!" + name;
    }

    @PostMapping("hello/{name}")
    public String testPostName(@PathVariable String name, @RequestBody Map<String, Object> map) {
        System.out.println("B======> " + map);
        return "POST-Hello world B!" + name;
    }
}
