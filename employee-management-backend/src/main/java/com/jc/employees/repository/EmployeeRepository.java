package com.jc.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jc.employees.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}