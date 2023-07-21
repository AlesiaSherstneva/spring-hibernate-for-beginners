package com.luv2code.springboot.dao;

import com.luv2code.springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}