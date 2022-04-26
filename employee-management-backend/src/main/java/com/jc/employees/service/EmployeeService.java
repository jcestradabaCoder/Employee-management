package com.jc.employees.service;

import java.util.List;
import java.util.Map;

import com.jc.employees.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	Employee createEmployee(Employee employee);
	Employee getEmployeeById(Long employeeId);
	Employee updateEmployee(Long employeeId, Employee employeeRequest);
	Map<String, Boolean> deleteEmployee(Long employeeId);
}