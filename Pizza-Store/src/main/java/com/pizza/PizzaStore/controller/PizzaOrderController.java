package com.pizza.PizzaStore.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pizza.PizzaStore.business.bean.PizzaOrderBean;
import com.pizza.PizzaStore.service.PizzaService;

@Controller
public class PizzaOrderController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@RequestMapping(value = "/LoadPizzaOrder", method = RequestMethod.GET )
	public ModelAndView loadSavePizza() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("PizzaOrder");
		mv.addObject("pizzaOrderObj", new PizzaOrderBean());
		return mv;
	}
	
	@PostMapping(value = "/SavePizzaOrder")
	public ModelAndView addPizzaOrderDetails(@ModelAttribute("pizzaOrderObj") PizzaOrderBean pizzaOrderBean) throws Exception {
		ModelAndView mv = new ModelAndView();
		PizzaOrderBean bean = pizzaService.addPizzaOrderDetails(pizzaOrderBean);
		mv.setViewName("PizzaOrderSuccess");
		mv.addObject("message","Hi "+bean.getCustomerName()+
								" Your order is placed with order Id: "+ bean.getOrderId()+
								", Bill to be paid is: "+bean.getBill());
		return mv;
	}
	
	@ModelAttribute("pizzaNamesAndId")
	public Map<Integer, String> populatePizzaNames() throws Exception{
		return pizzaService.findAllPizzaDetails();
	}
	
	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleAllException(Exception exception) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("GereralisedExceptionHandlerPage");
		mv.addObject("message", exception.getStackTrace());
		return mv;
	}

}
