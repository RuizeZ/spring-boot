package com.zeze.springboot.rest.recurity.service;

import com.zeze.springboot.rest.recurity.dao.EmployeeSecurityRepository;
import com.zeze.springboot.rest.recurity.entity.EmployeeSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeSecurityServiceImpl implements EmployeeSecurityService{
    private EmployeeSecurityRepository employeeRepository;

    @Autowired
    public EmployeeSecurityServiceImpl(EmployeeSecurityRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }
    @Override
    public List<EmployeeSecurity> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeSecurity findById(int theId) {
        Optional<EmployeeSecurity> result = employeeRepository.findById(theId);

        EmployeeSecurity theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public EmployeeSecurity save(EmployeeSecurity theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
