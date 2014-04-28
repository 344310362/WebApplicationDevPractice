package com.springPractice.service;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.springPractice.service.PriceIncrease;
public class PriceIncreaseValidator implements Validator {
	public boolean supports(Class clazz) {
		return PriceIncrease.class.equals(clazz);
	}

	public void validate(Object obj, Errors errors) {
		PriceIncrease priceIncrease = (PriceIncrease) obj;
		
		if(priceIncrease == null){
			errors.rejectValue("percentage", "error.not-specified", null, "Value required");
			return;
		}
		
		if(priceIncrease.getPercentage() > 50)
			errors.rejectValue("percentage", "error.too-high", new Object[] {new Integer(50)}, "Value too high");
		
		if(priceIncrease.getPercentage() < 0)
			errors.rejectValue("percentage", "error.too-low", new Object[] {new Integer(0)}, "Value too low");
	}
}
