package com.springPractice.repository;

import java.util.List;
import com.springPractice.domain.Product;

public interface ProductDao {
	public List<Product> getProductList();
	public void saveProduct(Product product);
}
