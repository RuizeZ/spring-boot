package com.zeze.springboot.service;

import com.zeze.springboot.dao.EmployeeJPARepository;
import com.zeze.springboot.eneity.EmployeeJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeJPAServiceImpl implements EmployeeJPAService {
    private EmployeeJPARepository employeeJPARepository;

    @Autowired
    public EmployeeJPAServiceImpl(EmployeeJPARepository employeeJPARepository) {
        this.employeeJPARepository = employeeJPARepository;
    }

    @Override
    public List<EmployeeJPA> findAll() {
        return employeeJPARepository.findAll();
    }

    @Override
    public EmployeeJPA findById(int theId) {
        Optional<EmployeeJPA> result = employeeJPARepository.findById(theId);
        EmployeeJPA theEmployeeJPA = null;
        if (result.isPresent()){
            theEmployeeJPA = result.get();
        }else {
            throw new RuntimeException("Did not find employee id of " + theId);
        }
        return theEmployeeJPA;
    }

    @Override
    public EmployeeJPA save(EmployeeJPA theEmployeeJPA) {
        EmployeeJPA dbEmployeeJPA = employeeJPARepository.save(theEmployeeJPA);
        return dbEmployeeJPA;
    }

    @Override
    public void deletedById(int theId) {
        employeeJPARepository.delete(findById(theId));
    }
}
