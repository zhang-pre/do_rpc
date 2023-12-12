package com.qf.provider.api.common.protocol.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Thor
 * @公众号 Java架构栈
 */
public class DispatcherServlet extends HttpServlet {
    //note DispatcherServlet调用HttpServerHandler中的handler方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new HttpServerHandler().handler(req, resp);
    }
}
