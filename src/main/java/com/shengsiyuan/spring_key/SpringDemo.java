package com.shengsiyuan.spring_key;

import com.shengsiyuan.spring_key.beans.Student;
import com.shengsiyuan.spring_key.service.AopService;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.lang.reflect.Proxy;

public class SpringDemo {

    public static void main(String[] args) {
        Resource resource = new ClassPathResource("applicationContext.xml");

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        beanDefinitionReader.loadBeanDefinitions(resource);

//        Student student = ((Student) defaultListableBeanFactory.getBean("student"));
/*
        System.out.println(student.getName());

        System.out.println(student.getAge());*/

        AopService aopService = (AopService) defaultListableBeanFactory.getBean("aopService");

        aopService.getStudent();

        AopService factoryBean = (AopService) defaultListableBeanFactory.getBean("factoryBean");

        factoryBean.getStudent();
    }
}
