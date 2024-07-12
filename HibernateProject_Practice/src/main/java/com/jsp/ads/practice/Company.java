package com.jsp.ads.practice;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {

	@Id
	private int companyId;
	private String companyName;
	
	
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
