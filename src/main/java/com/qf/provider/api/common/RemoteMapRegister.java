package com.qf.provider.api.common;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Thor
 * @公众号 Java架构栈
 */
public class RemoteMapRegister {

    // 该map存放的是接口名到其URL的映射，url为list是因为一个服务可能有多个实例
    /**例如：
     * DeviceService    192.168.2.11:9001
     * DeviceService    192.168.2.12:9001
     * */
    private static Map<String, List<URL>> REGISTER = new HashMap<>();

    /**
     * @param interfaceName 接口名字
     * @param url 该接口对应的url
     */
    public static void regist(String interfaceName, URL url){

        List<URL> list = REGISTER.get(interfaceName);
        if (list == null) {
            list = new ArrayList<>();

        }
        list.add(url);

        REGISTER.put(interfaceName, list);
        //note  saveFile实现REGISTER在provider和consumer之间共享
        saveFile();
    }

    public static List<URL> get(String interfaceName) {
        REGISTER = getFile();

        List<URL> list = REGISTER.get(interfaceName);
        return list;
    }



    //将Register对象写入到文件中，该文件在类路径下
    private static void saveFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("classpath:register.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(REGISTER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //从register.txt文件中读取一个Map对象
    private static Map<String, List<URL>> getFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("classpath:register.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, List<URL>>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
