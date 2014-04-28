package com.springPractice.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.springPractice.domain.Product;

public class TestSimpleProductManager {
	
	private static final String TABLE_DESCRIPTION = "Table";
	private static final String CHAIR_DESCRIPTION = "Chair";
	private static final double CHAIR_PRICE = 20.50;
	private static final double TABLE_PRICE = 150.10;
	private SimpleProductManager productManager = new SimpleProductManager();
	private List<Product> products = new ArrayList<Product>();
	@Before
	public void setUp(){
		Product product = new Product();
		
		product.setDescription(CHAIR_DESCRIPTION);
		product.setPrice(CHAIR_PRICE);
		products.add(product);
		
		product = new Product();
		product.setDescription(TABLE_DESCRIPTION);
		product.setPrice(TABLE_PRICE);
		products.add(product);
		
		productManager.setProducts(products);
	}
	
	@Test
	public void testGetProductsWithNoProducts() {
		productManager = new SimpleProductManager();
		assertNull(productManager.getProducts());
	}
	
	@Test
	public void testGetProducts(){
		List<Product> products = productManager.getProducts();
		assertNotNull(products);
		
		Product product = products.get(0);
		assertEquals(CHAIR_DESCRIPTION, product.getDescription());
		assertEquals(CHAIR_PRICE, product.getPrice(), 0);
		
		product = products.get(1);
		assertEquals(TABLE_DESCRIPTION, product.getDescription());
		assertEquals(TABLE_PRICE, product.getPrice(), 0);
	}

	public void testIncreasPriceWithEmptyListOfProducts(){
		try{
			productManager = new SimpleProductManager();
			productManager.setProducts(new ArrayList<Product>());
			productManager.increasePrice(10);
		}
		catch(Exception ex){
			fail("Products list is empty.");
		}
	}
	
	@Test
	public void testIncreasePriceWithPositivePercentage(){
		productManager.increasePrice(10);
		
		List<Product> products = productManager.getProducts();
		Product product = products.get(0);
		assertEquals(22.55, product.getPrice(), 0);
		
		product = products.get(1);
		assertEquals(165.11, product.getPrice(), 0);
	}
}
