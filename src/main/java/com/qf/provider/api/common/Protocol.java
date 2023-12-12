package com.qf.provider.api.common;

/**
 * @author Thor
 * @公众号 Java架构栈
 */
public interface Protocol {

    void start(URL url);

    String send(URL url, Invocation invocation);
}
