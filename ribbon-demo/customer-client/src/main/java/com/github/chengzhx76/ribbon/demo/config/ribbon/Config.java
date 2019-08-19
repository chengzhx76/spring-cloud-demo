package com.github.chengzhx76.ribbon.demo.config.ribbon;

import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.ribbon.RibbonClientName;
import org.springframework.context.annotation.Bean;

/**
 * @desc:
 * @author: hp
 * @date: 2019/8/16
 */
//@Configuration
public class Config {

    @RibbonClientName
    private String name = "client";

    @Bean
    @ConditionalOnMissingBean
    public IClientConfig ribbonClientConfig() {
        System.out.println("===========>ribbonClientConfig" +name);
//        DefaultClientConfigImpl config = new DefaultClientConfigImpl();
        DefaultClientConfigImpl config = new DatabaseClientConfig(name);
        config.loadProperties(this.name);
        config.set(CommonClientConfigKey.ConnectTimeout, 1000);
        config.set(CommonClientConfigKey.ReadTimeout, 1000);
        config.set(CommonClientConfigKey.GZipPayload, true);
        config.setProperty(CommonClientConfigKey.ListOfServers, "localhost:8003");
        return config;
    }

    /*@Bean
    public ServerList<Server> ribbonServerList() {
        System.out.println("===========>ribbonServerList" +name);
        CustomServerList serverList = new CustomServerList();
        return serverList;
    }*/
}
