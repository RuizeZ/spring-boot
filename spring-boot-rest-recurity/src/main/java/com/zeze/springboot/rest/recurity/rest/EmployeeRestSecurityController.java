package com.zeze.springboot.rest.recurity.rest;

import com.zeze.springboot.rest.recurity.entity.EmployeeSecurity;
import com.zeze.springboot.rest.recurity.service.EmployeeSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/security")
public class EmployeeRestSecurityController {
    private EmployeeSecurityService employeeService;

    @Autowired
    public EmployeeRestSecurityController(EmployeeSecurityService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<EmployeeSecurity> findAll() {
        return employeeService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/employees/{employeeId}")
    public EmployeeSecurity getEmployee(@PathVariable int employeeId) {

        EmployeeSecurity theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }

    // add mapping for POST /employees - add new employee

    @PostMapping("/employees")
    public EmployeeSecurity addEmployee(@RequestBody EmployeeSecurity theEmployee) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theEmployee.setId(0);

        EmployeeSecurity dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/employees")
    public EmployeeSecurity updateEmployee(@RequestBody EmployeeSecurity theEmployee) {

        EmployeeSecurity dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        EmployeeSecurity tempEmployee = employeeService.findById(employeeId);

        // throw exception if null

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }

}
