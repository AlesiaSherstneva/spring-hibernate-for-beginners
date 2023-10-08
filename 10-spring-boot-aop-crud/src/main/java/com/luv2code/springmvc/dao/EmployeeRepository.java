package com.luv2code.springmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springmvc.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByOrderByLastNameAsc();
}