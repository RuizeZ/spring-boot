package com.zeze.springboot.rest;

import com.zeze.springboot.eneity.EmployeeJPA;
import com.zeze.springboot.service.EmployeeJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/jpa")
public class EmployeeRestJPAController {
//    private EmployeeDAO employeeDAO;
    private EmployeeJPAService employeeJPAService;
    @Autowired
    public EmployeeRestJPAController (EmployeeJPAService employeeJPAService){
        this.employeeJPAService = employeeJPAService;
    }

    @GetMapping("/employees")
    public List<EmployeeJPA> findAll(){
        return employeeJPAService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public EmployeeJPA getEmployee(@PathVariable int employeeId){
        EmployeeJPA theEmployeeJPA = employeeJPAService.findById(employeeId);
        if(theEmployeeJPA == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return theEmployeeJPA;
    }

    @PostMapping("/employees")
    public EmployeeJPA addEmployee(@RequestBody EmployeeJPA theEmployeeJPA){
        theEmployeeJPA.setId(0);
        EmployeeJPA dbEmployeeJPA = employeeJPAService.save(theEmployeeJPA);
        return dbEmployeeJPA;
    }

    @PutMapping("/employees")
    public EmployeeJPA updateEmployee(@RequestBody EmployeeJPA theEmployeeJPA){
        EmployeeJPA dbEmployeeJPA = employeeJPAService.save(theEmployeeJPA);
        return dbEmployeeJPA;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String delectEmployee(@PathVariable int employeeId){
        EmployeeJPA theEmployeeJPA = employeeJPAService.findById(employeeId);
        if(Objects.isNull(theEmployeeJPA)){
            throw new RuntimeException("employee id not found");
        }
        employeeJPAService.deletedById(employeeId);
        return "Deleted employee id - " + employeeId;
    }
}
