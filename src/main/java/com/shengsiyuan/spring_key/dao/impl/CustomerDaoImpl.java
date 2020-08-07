package com.shengsiyuan.spring_key.dao.impl;

import com.shengsiyuan.spring_key.beans.Customer;
import com.shengsiyuan.spring_key.beans.Student;
import com.shengsiyuan.spring_key.dao.CustomerDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerDaoImpl implements CustomerDao {

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveCustomer(Customer customer) {
        jdbcTemplate.update("insert into customer (name, age) values (?, ?)", customer.getName(), customer.getAge());
    }
}
