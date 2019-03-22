package org.rpcframework;

import com.vilderlee.rpc.HelloService;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/22      Create this file
 * </pre>
 */

public class Test {
    public static void main(String[] args) throws Exception {
        Context context = new Context("rpc.xml");
        HelloService helloService = (HelloService) context.getBean("helloServiceImpl");
        System.out.println(helloService.sayHello());
    }
}
