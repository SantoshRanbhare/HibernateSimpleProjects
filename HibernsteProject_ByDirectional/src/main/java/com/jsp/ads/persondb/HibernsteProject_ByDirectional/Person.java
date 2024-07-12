package com.jsp.ads.persondb.HibernsteProject_ByDirectional;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	
	@Id
	private int personId;
	private String personName;
	
	@OneToOne(mappedBy = "person",fetch = FetchType.EAGER)
	private Pan pan;


	public int getPersonId() {
		return personId;
	}


	public void setPersonId(int personId) {
		this.personId = personId;
	}


	public String getPersonName() {
		return personName;
	}


	public void setPersonName(String personName) {
		this.personName = personName;
	}


	public Pan getPan() {
		return pan;
	}


	public void setPan(Pan pan) {
		this.pan = pan;
	}
}
