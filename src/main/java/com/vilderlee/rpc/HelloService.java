package com.vilderlee.rpc;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/19      Create this file
 * </pre>
 */
public interface HelloService {
    String sayHello();

    HelloResponse doBusiness(HelloRequest request);
}
