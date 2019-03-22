package com.vilderlee.rpc;

import java.io.Serializable;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/21      Create this file
 * </pre>
 */
public class HelloResponse implements Serializable {
    private static final long serialVersionUID = 2484096550754339719L;
    private String responseMsg;

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }
}
