package com.ems.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity()
@Table(name = "Employee_Details")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Employee_id")
	private int emp_id;
	@Column(name = "Employee_name")
	private String emp_name;
	@Column(name = "Employee_emailid")
	private String emp_email;
	@Column(name = "Employee_salary")
	private double emp_salary;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int emp_id, String emp_name, String emp_email, double emp_salary) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.emp_salary = emp_salary;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public double getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(double emp_salary) {
		this.emp_salary = emp_salary;
	}

}
