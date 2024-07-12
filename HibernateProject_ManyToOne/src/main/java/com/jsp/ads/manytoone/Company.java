package com.jsp.ads.manytoone;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Company {
	
	@Id
	private int companyId;
	private String companyName;
	
	@OneToMany
	private List<Employee> employees = new ArrayList<Employee>();
	
	List<Employee> getEmployees() {
		return employees;
	}
	void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	int getCompanyId() {
		return companyId;
	}
	void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	String getCompanyName() {
		return companyName;
	}
	void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
