package com.zeze.springboot.cruddemo.dao;

import com.zeze.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
