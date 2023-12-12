package com.qf.consumer;

import com.qf.provider.api.HelloService;
import com.qf.provider.api.common.ProxyFactory;

/**
 * @author Thor
 * @公众号 Java架构栈
 */
public class Consumer {
    public static void main(String[] args) {
        //note 这里helloService是代理对象，这个代理对象将用于远程调用 HelloService 接口的方法（hello()方法）。
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        //note 通过代理对象 helloService 调用 HelloService 接口的 hello() 方法，传入参数 "qf"。
        // 这个方法调用会被代理对象的 invoke() 方法处理。
        String name = helloService.hello("qf");
        System.out.println(name);
    }
}
