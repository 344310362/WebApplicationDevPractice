package com.springPractice.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springPractice.service.ProductManager;

@Controller
public class InventoryController{

	@Autowired
	private ProductManager productManager;

	@RequestMapping("/hello.htm")
	public ModelAndView handleRequest() throws Exception {
		String now = (new Date()).toString();

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", now);
		myModel.put("products", this.productManager.getProducts());		
		return new ModelAndView("hello", "model", myModel);
	}
	
	public void setProductManager(ProductManager productManager){
		this.productManager = productManager;
	}
}
