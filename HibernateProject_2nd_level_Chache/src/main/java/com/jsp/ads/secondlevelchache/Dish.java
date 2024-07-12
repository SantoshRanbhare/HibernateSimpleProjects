package com.jsp.ads.secondlevelchache;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
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
