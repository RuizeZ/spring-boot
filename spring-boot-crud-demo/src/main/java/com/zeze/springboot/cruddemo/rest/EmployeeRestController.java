package com.zeze.springboot.cruddemo.rest;

import com.zeze.springboot.cruddemo.entity.Employee;
import com.zeze.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
//    private EmployeeDAO employeeDAO;
    private EmployeeService employeeService;
//    public EmployeeRestController (EmployeeDAO employeeDAO){
//        this.employeeDAO = employeeDAO;
//    }
    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String delectEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if(Objects.isNull(theEmployee)){
            throw new RuntimeException("employee id not found");
        }
        employeeService.deletedById(employeeId);
        return "Deleted employee id - " + employeeId;
    }
}
