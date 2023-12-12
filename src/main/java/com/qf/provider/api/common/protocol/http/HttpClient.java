package com.qf.provider.api.common.protocol.http;

import com.qf.provider.api.common.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Thor
 * @公众号 Java架构栈
 */
public class HttpClient {

    public String send(String hostname, Integer port, Invocation invocation) {

        try {
            URL url = new URL("http", hostname, port, "/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);

            //note  将Invocation对象通过输出流发送到服务器。
            OutputStream outputStream = httpURLConnection.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(invocation);
            oos.flush();
            oos.close();

            //将服务器的响应读取为字符串形式并返回
            //阻塞式等待！！！
            InputStream inputStream = httpURLConnection.getInputStream();
            String result = IOUtils.toString(inputStream);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
}
