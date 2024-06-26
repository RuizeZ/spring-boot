package com.zeze.springboot.service;
import com.zeze.springboot.entity.EmployeeJPA;

import java.util.List;

public interface EmployeeJPAService {
    List<EmployeeJPA> findAll();

    EmployeeJPA findById(int theId);

    EmployeeJPA save(EmployeeJPA theEmployeeJPA);

    void deletedById(int theId);
}
