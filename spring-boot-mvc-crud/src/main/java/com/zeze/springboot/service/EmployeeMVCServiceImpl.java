package com.zeze.springboot.service;

import com.zeze.springboot.dao.EmployeeMVCRepository;
import com.zeze.springboot.entity.EmployeeMVC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeMVCServiceImpl implements EmployeeMVCService {
    private EmployeeMVCRepository employeeJPARepository;

    @Autowired
    public EmployeeMVCServiceImpl(EmployeeMVCRepository employeeJPARepository) {
        this.employeeJPARepository = employeeJPARepository;
    }

    @Override
    public List<EmployeeMVC> findAll() {
        return employeeJPARepository.findAll();
    }

    @Override
    public EmployeeMVC findById(int theId) {
        Optional<EmployeeMVC> result = employeeJPARepository.findById(theId);
        EmployeeMVC theEmployeeJPA = null;
        if (result.isPresent()){
            theEmployeeJPA = result.get();
        }else {
            throw new RuntimeException("Did not find employee id of " + theId);
        }
        return theEmployeeJPA;
    }

    @Override
    public EmployeeMVC save(EmployeeMVC theEmployeeJPA) {
        EmployeeMVC dbEmployeeJPA = employeeJPARepository.save(theEmployeeJPA);
        return dbEmployeeJPA;
    }

    @Override
    public void deletedById(int theId) {
        employeeJPARepository.delete(findById(theId));
    }
}
