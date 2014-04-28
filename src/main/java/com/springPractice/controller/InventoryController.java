package com.springPractice.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springPractice.service.ProductManager;

public class InventoryController implements Controller{

	private ProductManager productManager;

	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
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
