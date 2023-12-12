package com.qf.provider.api.common.protocol.http;


import com.qf.provider.api.common.Invocation;
import com.qf.provider.api.common.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;

/**
 * @author Thor
 * @公众号 Java架构栈
 */
public class HttpServerHandler {
    //note 很关键的方法
    public void handler(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ObjectInputStream ois = new ObjectInputStream(req.getInputStream());
            Invocation invocation = (Invocation)ois.readObject();
            String interfaceName = invocation.getInterfaceName();//HelloService
            Class implClass = LocalRegister.get(interfaceName);//HelloServiceImpl.hello(String name)
            // 使用反射获取实现类中与Invocation对象中的方法名称和参数类型匹配的方法对象。
            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            //通过反射调用方法对象，传入实例化的实现类对象和Invocation对象中的参数值，执行方法并获取返回值。
            String result = (String) method.invoke(implClass.newInstance(), invocation.getParams());//HelloServiceImpl.hello(String name)
            System.out.println("tomcat:" + result);
            IOUtils.write(result.getBytes(), resp.getOutputStream());//写回给服务的消费者
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
