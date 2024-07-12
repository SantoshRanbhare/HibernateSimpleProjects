package com.jsp.ads.manytoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	
	@Id
	private int employeeId;
	private String employeeName;
	private double employeeSalary;
	
	@ManyToOne
	private Company company;
	
	Company getCompany() {
		return company;
	}
	void setCompany(Company company) {
		this.company = company;
	}
	int getEmployeeId() {
		return employeeId;
	}
	void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	String getEmployeeName() {
		return employeeName;
	}
	void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	double getEmployeeSalary() {
		return employeeSalary;
	}
	void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

}
