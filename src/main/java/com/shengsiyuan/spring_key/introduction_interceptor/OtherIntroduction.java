package com.shengsiyuan.spring_key.introduction_interceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

public class OtherIntroduction implements IntroductionInterceptor, IOther {
    @Override
    public void doOther() {
        System.out.println("do Other");
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // 如果呼叫的方法来自IOther切面的定义
        if (implementsInterface(invocation.getMethod().getDeclaringClass())) {
            // 呼叫执行额外加入（mixin）的行为
            return invocation.getMethod().invoke(this, invocation.getArguments());
        } else {
            return invocation.proceed();
        }
    }

    @Override
    public boolean implementsInterface(Class<?> intf) {
        return intf.isAssignableFrom(IOther.class);
    }
}
