package com.zeze.springboot.rest.recurity.service;

import com.zeze.springboot.rest.recurity.entity.EmployeeSecurity;

import java.util.List;
public interface EmployeeSecurityService {
    List<EmployeeSecurity> findAll();

    EmployeeSecurity findById(int theId);

    EmployeeSecurity save(EmployeeSecurity theEmployee);

    void deleteById(int theId);
}
