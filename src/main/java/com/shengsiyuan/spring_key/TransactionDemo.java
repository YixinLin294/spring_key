package com.shengsiyuan.spring_key;

import com.shengsiyuan.spring_key.beans.Customer;
import com.shengsiyuan.spring_key.service.CustomerService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TransactionDemo {

    public static void main(String[] args) {

        Resource resource = new ClassPathResource("applicationContext3.xml");

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        xmlBeanDefinitionReader.loadBeanDefinitions(resource);

        CustomerService customerService = (CustomerService) defaultListableBeanFactory.getBean("customerServiceProxy");

        Customer customer = new Customer();

        customer.setName("zhangsan");
        customer.setAge(10);

        customerService.saveCustomer(customer);

        System.out.println("debug");
    }
}
