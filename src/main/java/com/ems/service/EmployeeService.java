package com.ems.service;

import java.util.List;

import com.ems.entities.Employee;

public interface EmployeeService {

	void addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee employeeGetById(int id);

	boolean deleteEmployeeById(int emp_id);

	boolean deleteAllEmployees();

	Employee updateEmployeeById(int id, Employee employee);

}
