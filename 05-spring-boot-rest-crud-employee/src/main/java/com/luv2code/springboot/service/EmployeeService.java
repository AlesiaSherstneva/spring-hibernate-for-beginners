package com.luv2code.springboot.service;

import com.luv2code.springboot.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}