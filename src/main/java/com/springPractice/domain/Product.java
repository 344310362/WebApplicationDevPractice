package com.springPractice.domain;

public class Product {

	private String description;
	private double price;
	private int id;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
}
