package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entities.Employee;
import com.ems.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(HttpStatus.CREATED);
	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/employeeGetById/{id}")
	public Employee employeeGetById(@PathVariable("id") int id) {

		return employeeService.employeeGetById(id);

	}

	@DeleteMapping("/deleteEmployeeById/{emp_id}")
	public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable("emp_id") int emp_id) {
		employeeService.deleteEmployeeById(emp_id);
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}

	@DeleteMapping("/deleteAllEmployees")
	public ResponseEntity<Boolean> deleteAllEmployees() {
		employeeService.deleteAllEmployees();
		return new ResponseEntity<Boolean>(HttpStatus.OK);

	}

	@PostMapping("/updateEmployeeById/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable("id") int id, @RequestBody Employee employee) {
		employeeService.updateEmployeeById(id, employee);
		return new ResponseEntity<Employee>(HttpStatus.CREATED);

	}
}
