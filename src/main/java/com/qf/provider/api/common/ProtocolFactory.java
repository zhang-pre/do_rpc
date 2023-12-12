package com.qf.provider.api.common;

import com.qf.provider.api.common.protocol.dubbo.DubboProtocol;
import com.qf.provider.api.common.protocol.http.HttpProtocol;

/**
 * @author Thor
 * @公众号 Java架构栈
 */
public class ProtocolFactory {

    public static Protocol getProtocol() {

        //vm options：-DprotocolName=dubbo
        String name = System.getProperty("protocolName");
        if (name == null || name.equals("")) {name = "http";}
        switch (name) {
            case "http":
                return new HttpProtocol();
            case "dubbo":
                return new DubboProtocol();
            default:
                break;
        }
        return new HttpProtocol();

    }
}
