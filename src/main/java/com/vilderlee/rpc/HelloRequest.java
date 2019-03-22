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
public class HelloRequest implements Serializable {
    private static final long serialVersionUID = -5637355034440711178L;
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override public String toString() {
        return "HelloRequest{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
