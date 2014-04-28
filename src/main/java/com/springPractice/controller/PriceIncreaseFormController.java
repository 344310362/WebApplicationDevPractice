package com.springPractice.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.springPractice.service.PriceIncrease;
import com.springPractice.service.ProductManager;

public class PriceIncreaseFormController extends SimpleFormController {

	private ProductManager productManager;

	public ModelAndView onSubmit(Object command){
		int percentage = ((PriceIncrease) command).getPercentage();
		productManager.increasePrice(percentage);
		return new ModelAndView(new RedirectView(getSuccessView()));
	}

	public Object formBackingObject(HttpServletRequest request) throws ServletException{
		return new PriceIncrease();
	}
	
	public void setProductManager(ProductManager productManager){
		this.productManager = productManager;
	}
}
