package com.vilderlee.rpc;

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
public class HelloServiceImpl implements HelloService {

    private String name;



    @Override
    public String sayHello() {
       return "Hello" + name;
    }

    @Override
    public HelloResponse doBusiness(HelloRequest request) {
        System.out.println(request.toString());
        HelloResponse helloResponse = new HelloResponse();
        helloResponse.setResponseMsg(request.toString());
        return helloResponse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
