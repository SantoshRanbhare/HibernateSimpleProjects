package com.jsp.ads.levelonecaching;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dish {

	@Id
	private int dishId;
	private String dishName;
	private String dishType;
	private double dishPrice;
	
	int getDishId() {
		return dishId;
	}
	void setDishId(int dishId) {
		this.dishId = dishId;
	}
	String getDishName() {
		return dishName;
	}
	void setDishName(String dishName) {
		this.dishName = dishName;
	}
	String getDishType() {
		return dishType;
	}
	void setDishType(String dishType) {
		this.dishType = dishType;
	}
	double getDishPrice() {
		return dishPrice;
	}
	void setDishPrice(double dishPrice) {
		this.dishPrice = dishPrice;
	}
	
	
}
