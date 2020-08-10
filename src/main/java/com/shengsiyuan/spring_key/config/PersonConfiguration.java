package com.shengsiyuan.spring_key.config;

import com.shengsiyuan.spring_key.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class PersonConfiguration {

    @Bean(value = "person")
    public Person getPerson() {
        Person person = new Person();
        person.setBirth(new Date());
        person.setName("zhangsan");
        return person;
    }
}
