package com.jc.employees.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jc.employees.exception.ResourceNotFoundException;
import com.jc.employees.model.Employee;
import com.jc.employees.repository.EmployeeRepository;
import com.jc.employees.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
		return employee;
	}

	@Override
	public Employee updateEmployee(Long employeeId, Employee employeeRequest) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
		
		employee.setName(employeeRequest.getName());
		employee.setSurname(employeeRequest.getSurname());
		employee.setEmail(employeeRequest.getEmail());
		return employeeRepository.save(employee);
	}

	@Override
	public Map<String,Boolean> deleteEmployee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> resp = new HashMap<>();
		resp.put("delete",Boolean.TRUE);
		return resp;
	}
}