package com.shengsiyuan.spring_key;

import com.shengsiyuan.spring_key.beans.Student;
import com.shengsiyuan.spring_key.service.AopService;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class SpringDemo {

    public static void main(String[] args) {
        Resource resource = new ClassPathResource("applicationContext.xml");

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        beanDefinitionReader.loadBeanDefinitions(resource);

        Student student = ((Student) defaultListableBeanFactory.getBean("student"));

        System.out.println(student.getName());

        System.out.println(student.getAge());

        AopService aopService = (AopService) defaultListableBeanFactory.getBean("aopService");

        aopService.getStudent();

        AopService factoryBean = (AopService) defaultListableBeanFactory.getBean("factoryBean");

//        factoryBean.getStudent();

        Class<?> superclass = factoryBean.getClass().getSuperclass();
        System.out.println(superclass);

        Class<?>[] interfaces = factoryBean.getClass().getInterfaces();

        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }

        System.out.println("======================================");

        AopService myAop = (AopService) defaultListableBeanFactory.getBean("myAop");

        myAop.getStudent();

        Class<?> superclass1 = myAop.getClass().getSuperclass();
        System.out.println(superclass1);

        Class<?>[] interfaces1 = myAop.getClass().getInterfaces();

        for (Class<?> aClass : interfaces1) {
            System.out.println(aClass);
        }
    }
}
