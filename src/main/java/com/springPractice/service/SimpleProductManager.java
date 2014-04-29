package com.springPractice.service;

import java.util.List;

import com.springPractice.domain.Product;
import com.springPractice.repository.ProductDao;

public class SimpleProductManager implements ProductManager {

//	private List<Product> products;
	private ProductDao productDao;

	public void increasePrice(int percentage) {
		List<Product> products = getProducts();
		if(products == null) return;
		
		for(Product product : products){
			double newPrice = product.getPrice() * (100 + percentage)/100;
			product.setPrice(newPrice);
		}
	}

	public List<Product> getProducts() {
//		return products;
		return productDao.getProductList();
	}

//	public void setProducts(List<Product> products) {
//		this.products = products;
//	}
	
	public void setProductDao(ProductDao productDao){
		this.productDao = productDao;
	}
}
