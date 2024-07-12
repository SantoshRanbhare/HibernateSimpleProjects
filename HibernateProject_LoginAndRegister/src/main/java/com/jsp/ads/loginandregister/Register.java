package com.jsp.ads.loginandregister;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Register {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String userMail;
	private String userPassword;
	
	int getUserId() {
		return userId;
	}
	void setUserId(int userId) {
		this.userId = userId;
	}
	String getUserName() {
		return userName;
	}
	void setUserName(String userName) {
		this.userName = userName;
	}
	String getUserMail() {
		return userMail;
	}
	void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	String getUserPassword() {
		return userPassword;
	}
	void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
}
