package com.github.chengzhx76.ribbon.demo.config.ribbon;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @desc:
 * @author: hp
 * @date: 2019/8/15
 */
public class CustomServerList implements ServerList<Server> {

    @Autowired
    private IClientConfig clientConfig;

    public CustomServerList() {
    }

    public CustomServerList(IClientConfig clientConfig) {
        System.out.println("================>getInitialListOfServers");
        this.clientConfig = clientConfig;
    }

    //@Override
    //public void initWithNiwsConfig(IClientConfig clientConfig) {
    //    System.out.println("================>initWithNiwsConfig");
    //    this.clientConfig = clientConfig;
    //}

    @Override
    public List<Server> getInitialListOfServers() {
        System.out.println("================>getInitialListOfServers");
        return getUpdatedListOfServers();
    }

    @Override
    public List<Server> getUpdatedListOfServers() {
        System.out.println(clientConfig);
        System.out.println("================>getUpdatedListOfServers");
//        String listOfServers = clientConfig.get(CommonClientConfigKey.ListOfServers);
        String listOfServers = "localhost:8004";
        return derive(listOfServers);
    }

    protected List<Server> derive(String value) {
        List<Server> list = Lists.newArrayList();
        if (!Strings.isNullOrEmpty(value)) {
            for (String s: value.split(",")) {
                list.add(new Server(s.trim()));
            }
        }
        return list;
    }
}
