package com.github.chengzhx76.ribbon.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @desc:
 * @author: hp
 * @date: 2019/8/7
 */

//@EnableCircuitBreaker
//@EnableDiscoveryClienst
@RibbonClients(defaultConfiguration = com.github.chengzhx76.ribbon.demo.config.ribbon.Config.class)
@SpringBootApplication
public class CustomerClientApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerClientApplication.class, args);
    }

}
