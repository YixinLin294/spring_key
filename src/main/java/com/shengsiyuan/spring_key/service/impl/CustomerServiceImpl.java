package com.shengsiyuan.spring_key.service.impl;

import com.shengsiyuan.spring_key.beans.Customer;
import com.shengsiyuan.spring_key.dao.CustomerDao;
import com.shengsiyuan.spring_key.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);

//        throw new RuntimeException("transactional exception");
    }
}
