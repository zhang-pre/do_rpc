package com.qf.provider.api.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Thor
 * @公众号 Java架构栈
 */
public class LocalRegister {
    // 这个map存放的接口的名字，和其实现类的Class的映射
    private static Map<String, Class> map = new HashMap<>();
    /**
     * @param interfaceName 接口名字
     * @param implClass 实现类的Class
     */
    public static void regist(String interfaceName, Class implClass) {
        map.put(interfaceName, implClass);
    }

    public static Class get(String interfaceName) {
        return map.get(interfaceName);
    }
}
