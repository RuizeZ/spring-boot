package com.zeze.springboot.controller;

import com.zeze.springboot.entity.EmployeeMVC;
import com.zeze.springboot.service.EmployeeMVCService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "list-employees";
    }

}
