package com.luv2code.springmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springmvc.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}