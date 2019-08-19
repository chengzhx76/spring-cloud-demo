package com.github.chengzhx76.ribbon.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @desc:
 * @author: hp
 * @date: 2019/8/7
 */

@RestController
public class ServiceCController {

    @GetMapping("hello")
    public String test() {
        return "Hello world C!";
    }

    @GetMapping("hello/{name}")
    public String testGetName(@PathVariable String name) {
        return "GET-Hello world C!" + name;
    }

    @PostMapping("hello/{name}")
    public String testPostName(@PathVariable String name, @RequestBody Map<String, Object> map) {
        System.out.println("C======> " + map);
        return "POST-Hello world C!" + name;
    }
}
