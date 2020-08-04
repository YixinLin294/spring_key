package com.shengsiyuan.spring_key.proxy.jdk;

public class SpringAop {
    public void before() {
        System.out.println("before invoke: spring-aop");
    }

    public void after() {
        System.out.println("after invoke: spring-aop");
    }
}
