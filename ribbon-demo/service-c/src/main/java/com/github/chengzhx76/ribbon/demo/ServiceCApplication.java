package com.github.chengzhx76.ribbon.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @desc:
 * @author: hp
 * @date: 2019/8/7
 */

//@EnableDiscoveryClient
@SpringBootApplication
public class ServiceCApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceCApplication.class, args);
    }
}
