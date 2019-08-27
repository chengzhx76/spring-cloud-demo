package com.github.chengzhx76.test;

import com.github.chengzhx76.ribbon.demo.CustomerClientApplication;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc:
 * @author: hp
 * @date: 2019/8/9
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerClientApplication.class)
//@WebAppConfiguration
public class TestRestTemplate {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @Test
    public void testEnv() {
        System.out.println(env.getProperty("ribbon.listOfServers"));
    }


    @Test
    public void testGet1() {
        String data = restTemplate.getForObject("http://test-service-a", String.class);
        System.out.println("============>" + data);
//        String data = restTemplate.getForObject("http://test-service-c/hello/{1}", String.class, "cheng");
//        System.out.println("============>" + data);
    }

    @Test
    public void testGet2() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "cheng-2");
        String data = restTemplate.getForObject("http://test-service/hello/{name}", String.class, map);
        System.out.println("============>" + data);
    }

    @Ignore
    @Test
    public void testPost() {

        Map<String, Object> map = new HashMap<>();
        map.put("test", "test-value");

        String data = restTemplate.postForObject("http://test-service/hello/{1}", map, String.class, "cheng");
        System.out.println("============>" + data);
    }

}
