package com.shengsiyuan.spring_key;

import com.shengsiyuan.spring_key.beans.Person;
import com.shengsiyuan.spring_key.config.PersonConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(PersonConfiguration.class);

        annotationConfigApplicationContext.refresh();

        Person person = ((Person) annotationConfigApplicationContext.getBean("person"));

        System.out.println(person);
    }
}
