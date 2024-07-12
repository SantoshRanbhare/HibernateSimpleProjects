package com.jsp.ads.employeedb;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private int employeeId;
	private String employeeName;
	private String employeeMail;
	private String employeeAddress;
	private double employeeSalary;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeMail() {
		return employeeMail;
	}
	public void setEmployeeMail(String employeeMail) {
		this.employeeMail = employeeMail;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	@Override
	public String toString() {
		return "\nEmployeeId\tEmployeeName\tEmployeeMail\t\tEmployeeAddress\t\tEmployeeSalary\n"
				+employeeId+"\t\t"+employeeName+"\t\t"+employeeMail+"\t\t"+employeeAddress+"\t\t"+
				employeeSalary+"\n";
	}
}
