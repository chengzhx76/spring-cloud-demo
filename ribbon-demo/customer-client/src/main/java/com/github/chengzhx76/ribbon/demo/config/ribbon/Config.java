package com.github.chengzhx76.ribbon.demo.config.ribbon;

import org.springframework.context.annotation.Configuration;

/**
 * @desc:
 * @author: hp
 * @date: 2019/8/16
 */
@Configuration
public class Config {

//    @RibbonClientName
    private String name = "client";

    /*@Bean
    @ConditionalOnMissingBean
    public IClientConfig ribbonClientConfig() {
        DefaultClientConfigImpl config = new DefaultClientConfigImpl();
        config.loadProperties(this.name);
        config.set(CommonClientConfigKey.ConnectTimeout, 1000);
        config.set(CommonClientConfigKey.ReadTimeout, 1000);
        config.set(CommonClientConfigKey.GZipPayload, true);
        return config;
    }

    @Bean
    public ServerList<Server> ribbonServerList(IClientConfig config) {
        CustomServerList serverList = new CustomServerList();
        return serverList;
    }*/
}
