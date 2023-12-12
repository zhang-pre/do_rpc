package com.qf.provider.api.impl;

import com.qf.provider.api.HelloService;

/**
 * @author Thor
 * @公众号 Java架构栈
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello:" + name;
    }
}
