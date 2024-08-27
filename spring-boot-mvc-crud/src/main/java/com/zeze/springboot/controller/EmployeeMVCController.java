package com.zeze.springboot.controller;

import com.zeze.springboot.entity.EmployeeMVC;
import com.zeze.springboot.service.EmployeeMVCService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/mvc")
public class EmployeeMVCController {
    private EmployeeMVCService employeeMVCService;
    public EmployeeMVCController(EmployeeMVCService employeeMVCService){
        this.employeeMVCService = employeeMVCService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel){
        List<EmployeeMVC> theEmployees = employeeMVCService.findAll();
        theModel.addAttribute("employees", theEmployees);
        return "employees/list-employees";
    }

    @GetMapping("/add")
    public String add(Model theModel){
        EmployeeMVC theEmployee = new EmployeeMVC();
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") EmployeeMVC theEmployee){
        employeeMVCService.save(theEmployee);
        return "redirect:/api/mvc/list";
    }

    @GetMapping("/update")
    public String udpate(@RequestParam("employeeId") int theId, Model theModel){
        EmployeeMVC theEmployee = employeeMVCService.findById(theId);
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){
        employeeMVCService.deletedById(theId);
        return "redirect:/api/mvc/list";
    }



}
