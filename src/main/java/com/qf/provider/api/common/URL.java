package com.qf.provider.api.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Thor
 * @公众号 Java架构栈
 */
@Data
@AllArgsConstructor
public class URL implements Serializable {
    private String hostName;
    private int port;



}
