package com.shengsiyuan.spring_key.service.impl;

import com.shengsiyuan.spring_key.beans.Student;
import com.shengsiyuan.spring_key.service.AopService;
import lombok.Data;

@Data
public class AopServiceImpl implements AopService {

    private Student student = new Student();

    {
        student.setName("lisi");
        student.setAge(100);
    }

    @Override
    public Student getStudent() {
        System.out.println(student.getAge());
        System.out.println(student.getName());
        return student;
    }
}
