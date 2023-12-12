package com.qf.provider.api.common;

import java.util.List;
import java.util.Random;

/**
 * @author Thor
 * @公众号 Java架构栈
 */
public class LoadBalance {

    public static URL random(List<URL> list) {
        Random random =new Random();
        int n = random.nextInt(list.size());
        return list.get(n);
    }



}
