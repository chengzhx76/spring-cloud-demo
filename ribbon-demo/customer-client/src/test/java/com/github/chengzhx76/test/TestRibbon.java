package com.github.chengzhx76.test;

import com.netflix.config.ConfigurationManager;
import org.junit.Test;

import java.io.IOException;

/**
 * @desc: https://github.com/Netflix/ribbon/wiki/Getting-Started
 * @author: hp
 * @date: 2019/8/16
 */
public class TestRibbon {

    @Test
    public void testArchaius () throws IOException {
//        ConfigurationManager.loadPropertiesFromResources("application-test.yml");  // 1
//        System.out.println(ConfigurationManager.getConfigInstance().getProperty("test-service-a.ribbon.listOfServers"));

        ConfigurationManager.loadPropertiesFromResources("sample-client.properties");  // 1
        System.out.println(ConfigurationManager.getConfigInstance().getProperty("sample-client.ribbon.listOfServers"));
    }
}
