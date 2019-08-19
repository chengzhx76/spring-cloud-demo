package com.github.chengzhx76.ribbon.demo.controller;

import com.github.chengzhx76.ribbon.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: hp
 * @date: 2019/8/7
 */

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("hi/{rule}")
    public String customer(@PathVariable String rule){
        return customerService.helloService(rule);
    }
}
