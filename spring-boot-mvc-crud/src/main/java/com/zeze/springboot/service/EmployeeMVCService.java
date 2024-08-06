package com.zeze.springboot.service;

import com.zeze.springboot.entity.EmployeeMVC;

import java.util.List;

public interface EmployeeMVCService {
    List<EmployeeMVC> findAll();

    EmployeeMVC findById(int theId);

    EmployeeMVC save(EmployeeMVC theEmployeeJPA);

    void deletedById(int theId);
}
