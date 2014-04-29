package com.springPractice.repository;

import java.util.List;

import com.springPractice.domain.Product;

public class InMemoryProductDao implements ProductDao {
	private List<Product> products;
	
	public InMemoryProductDao(List<Product> products){
		this.products = products;
	}

	public List<Product> getProductList() {
		return products;
	}

	public void saveProduct(Product product) {
	}
}
