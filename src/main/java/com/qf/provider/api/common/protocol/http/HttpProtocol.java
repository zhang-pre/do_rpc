package com.qf.provider.api.common.protocol.http;


import com.qf.provider.api.common.Invocation;
import com.qf.provider.api.common.Protocol;
import com.qf.provider.api.common.URL;

/**
 * @author Thor
 * @公众号 Java架构栈
 */
public class HttpProtocol implements Protocol {

    @Override
    public void start(URL url) {
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostName(), url.getPort());//tomcat-》DispatcherServlet接收请求
    }

    @Override
    public String send(URL url, Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.send(url.getHostName(), url.getPort(),invocation);
    }
}
