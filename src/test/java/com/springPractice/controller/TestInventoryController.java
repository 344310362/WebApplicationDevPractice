package com.springPractice.controller;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.springPractice.repository.InMemoryProductDao;
import com.springPractice.repository.ProductDao;
import com.springPractice.service.SimpleProductManager;

public class TestInventoryController {

	InventoryController controller = new InventoryController();
	
	@Before
	public void setUp(){
		ProductDao productDao = new InMemoryProductDao(null);
		SimpleProductManager productManager = new SimpleProductManager();
		productManager.setProductDao(productDao);
		controller.setProductManager(productManager);
	}
	
	@Test
	public void testHelloControllerWillReturnHelloJSPAsView() throws Exception {
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertEquals("hello", modelAndView.getViewName());
	}
	
	@Test
	public void testHelloControllerWillReturnModelWithParameterNow() throws Exception {
		ModelAndView modelAndView = controller.handleRequest(null, null);
		Map model = (Map)modelAndView.getModel().get("model");
		assertNotNull((String)model.get("now"));
	}
}



