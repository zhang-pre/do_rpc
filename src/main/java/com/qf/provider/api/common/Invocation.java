package com.qf.provider.api.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Thor
 * @公众号 Java架构栈
 */
import java.io.Serializable;

@Data
@AllArgsConstructor
public class Invocation implements Serializable {

    private String interfaceName;
    private String methodName;
    private Class[] paramTypes;
    private Object[] params;

}
