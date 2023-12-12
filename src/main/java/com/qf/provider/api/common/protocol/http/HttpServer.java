package com.qf.provider.api.common.protocol.http;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;

/**
 * @author Thor
 * @公众号 Java架构栈
 */
public class HttpServer {

    /**
     * 使用Tomcat作为服务器，通过指定主机名和端口号来配置服务器，并将DispatcherServlet映射到根路径。
     * 最后，启动服务器并等待请求。
     */

    public void start(String hostname, Integer port) {
        Tomcat tomcat = new Tomcat();
        Server server = tomcat.getServer();
        //从Server对象中获取名为"Tomcat"的Service对象。
        Service service = server.findService("Tomcat");

        Connector connector = new Connector();
        connector.setPort(port);

        Engine engine = new StandardEngine();
        engine.setDefaultHost(hostname);

        Host host = new StandardHost();
        host.setName(hostname);

        String contextPath = "";
        Context context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());

        host.addChild(context);
        engine.addChild(host);
        service.setContainer(engine);
        service.addConnector(connector);

        //note 注册和映射一个Servlet的操作  ,这里的DispatcherServlet是自己编写的，其实就是HttpServlet
        tomcat.addServlet(contextPath, "dispatcher", new DispatcherServlet());
        //note 将所有以"/"开头的URL请求都交给名为"dispatcher"的Servlet（即DispatcherServlet）进行处理。
        context.addServletMappingDecoded("/*", "dispatcher");
        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
