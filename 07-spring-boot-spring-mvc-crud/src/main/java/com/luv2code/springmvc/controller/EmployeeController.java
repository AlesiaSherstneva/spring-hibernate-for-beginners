package com.luv2code.springmvc.controller;

import com.luv2code.springmvc.entity.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        theModel.addAttribute("employees", theEmployees);
        return "list-employees";
    }
}