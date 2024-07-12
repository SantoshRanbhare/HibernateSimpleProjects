package com.jsp.ads.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mobile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mobileId;
	private String mobileModel;
	private String mobileBrand;
	private String mobileRam;
	private String mobileRom;
	private int mobilePrice;
	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
	public String getMobileModel() {
		return mobileModel;
	}
	public void setMobileModel(String mobileModel) {
		this.mobileModel = mobileModel;
	}
	public String getMobileBrand() {
		return mobileBrand;
	}
	public void setMobileBrand(String mobileBrand) {
		this.mobileBrand = mobileBrand;
	}
	public String getMobileRam() {
		return mobileRam;
	}
	public void setMobileRam(String mobileRam) {
		this.mobileRam = mobileRam;
	}
	public String getMobileRom() {
		return mobileRom;
	}
	public void setMobileRom(String mobileRom) {
		this.mobileRom = mobileRom;
	}
	public int getMobilePrice() {
		return mobilePrice;
	}
	public void setMobilePrice(int mobilePrice) {
		this.mobilePrice = mobilePrice;
	}
	
	
	
}
