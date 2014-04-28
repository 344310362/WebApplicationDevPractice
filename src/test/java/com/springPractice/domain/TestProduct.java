package com.springPractice.domain;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestProduct {
	private Product product = new Product();

	@Test
	public void testSetAndGetDescription() {
		String testDescription = "aDescription";
		assertNull(product.getDescription());
		product.setDescription(testDescription);
		assertEquals(testDescription, product.getDescription());
	}
	
	@Test
	public void testSetAndGetPrice(){
		double testPrice = 100.00;
		assertEquals(0, product.getPrice(), 0);
		product.setPrice(testPrice);
		assertEquals(testPrice, product.getPrice(), 0);
	}
}
