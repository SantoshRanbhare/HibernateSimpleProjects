package com.jsp.ads.persondb;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pan {
	
	@Id
	private int panId;
	private String panNum;
	
	public int getPanId() {
		return panId;
	}
	public void setPanId(int panId) {
		this.panId = panId;
	}
	public String getPanNum() {
		return panNum;
	}
	public void setPanNum(String panNum) {
		this.panNum  = panNum;
	}
	
	

}
