package com.shengsiyuan.spring_key.proxy.jdk;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("before invoke: MyAspect");
        Object proceed = invocation.proceed();
        System.out.println("after invoke: MyAspect");
        return proceed;
    }
}
