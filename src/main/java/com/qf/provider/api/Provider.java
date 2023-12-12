package com.qf.provider.api;


import com.qf.provider.api.common.*;
import com.qf.provider.api.impl.HelloServiceImpl;

/**
 * @author Thor
 * @公众号 Java架构栈
 */
public class Provider {
    public static void main(String[] args) {
        URL url = new URL("localhost",8080);



        //指明服务的实现类
        LocalRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);

        //从协议工厂中获取rpc使用的协议
        Protocol protocol = ProtocolFactory.getProtocol();
        protocol.start(url);

        //模拟远程注册中心
        RemoteMapRegister.regist(HelloService.class.getName(), url);

    }
}
