package com.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ems.entities.Employee;
import com.ems.exception.EmployeeNotFoundException;
import com.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.saveAndFlush(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();

//		List<Employee> employee2 = null;
//		if (!employeeRepository.existsById(employee.getEmp_id())) {
//			new EmployeeNotFoundException("No Such Employees Present in database");
//		} else {
//			employee2 = employeeRepository.findAll();
//		}
//		return employee2;
	}

	public Employee employeeGetById(int id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public boolean deleteEmployeeById(int emp_id) {
		if (!employeeRepository.findById(emp_id).equals(Optional.empty())) {
			employeeRepository.deleteById(emp_id);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAllEmployees() {
		if (!employeeRepository.equals(Optional.empty())) {
			employeeRepository.deleteAll();
			return true;
		}
		return false;
	}

	@Override
	public Employee updateEmployeeById(int id, Employee employee) {
		Employee current = employeeRepository.findById(id).get();
		current.setEmp_name(employee.getEmp_name());
		current.setEmp_email(employee.getEmp_email());
		current.setEmp_salary(employee.getEmp_salary());
		employeeRepository.save(current);
		return current;
	}
}
