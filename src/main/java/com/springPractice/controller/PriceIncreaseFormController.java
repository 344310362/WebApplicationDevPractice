package com.springPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.springPractice.service.PriceIncrease;
import com.springPractice.service.ProductManager;

@Controller
@RequestMapping("/priceincrease.htm")
public class PriceIncreaseFormController{

	@Autowired
	private ProductManager productManager;

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(
		@ModelAttribute("priceIncrease") PriceIncrease priceIncrease,
		BindingResult result, SessionStatus status){
		int percentage = priceIncrease.getPercentage();
		productManager.increasePrice(percentage);
		return "redirect:hello.htm";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model){
		
		PriceIncrease priceIncrease = new PriceIncrease();
		model.addAttribute("priceIncrease", priceIncrease);
		return "priceincrease";
	}
	
	public void setProductManager(ProductManager productManager){
		this.productManager = productManager;
	}
}
