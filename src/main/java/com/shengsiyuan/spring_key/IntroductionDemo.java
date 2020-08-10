package com.shengsiyuan.spring_key;

import com.shengsiyuan.spring_key.introduction_interceptor.IOther;
import com.shengsiyuan.spring_key.introduction_interceptor.ISome;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IntroductionDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:applicationContext4.xml");

        ISome some = (ISome) applicationContext.getBean("proxyFactoryBean");

        some.doSome();

        // 添加了 职责
        ((IOther) some).doOther();
    }
}
