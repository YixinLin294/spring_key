package com.shengsiyuan.spring_key;

import com.shengsiyuan.spring_key.beans.Person;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

public class ConvertDemo {

    public static void main(String[] args) {
        ClassPathResource resource = new ClassPathResource("applicationContext2.xml");

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        beanDefinitionReader.loadBeanDefinitions(resource);

        Object conversionService = defaultListableBeanFactory.getBean("conversionService");

        Person person = (Person) defaultListableBeanFactory.getBean("person");

        System.out.println(person.getInterests());

        System.out.println(person.getBirth());

    }
}
