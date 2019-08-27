package com.github.chengzhx76.kafka.test;

import com.github.chengzhx76.kafka.demo.KafkaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @desc:
 * @author: hp
 * @date: 2019/8/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaApplication.class)
public class TestRest {

    @Autowired
    private RestTemplate restTemplate;

//    ResourceAccessException

    @Test
    public void testGet1() {
//        try {
            String data = restTemplate.getForObject("http://localhost:8200/test", String.class);

            System.out.println("============>" + data);
//        } catch (ResourceAccessException e) {
//            System.out.println("----->ResourceAccessException");
//        }
    }
}
