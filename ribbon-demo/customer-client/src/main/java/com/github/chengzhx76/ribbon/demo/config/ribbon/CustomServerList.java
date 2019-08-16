package com.github.chengzhx76.ribbon.demo.config.ribbon;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractServerList;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @desc:
 * @author: hp
 * @date: 2019/8/15
 */
public class CustomServerList extends AbstractServerList<Server> {

    private IClientConfig clientConfig;

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        System.out.println("================>initWithNiwsConfig");
        this.clientConfig = clientConfig;
    }

    @Override
    public List<Server> getInitialListOfServers() {
        System.out.println("================>getInitialListOfServers");
        return getUpdatedListOfServers();
    }

    @Override
    public List<Server> getUpdatedListOfServers() {
        System.out.println("================>getUpdatedListOfServers");
//        String listOfServers = clientConfig.get(CommonClientConfigKey.ListOfServers);
        String listOfServers = "www.baidu.com,www.google.com";
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
