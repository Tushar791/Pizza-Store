package com.pizza.PizzaStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pizza.PizzaStore.business.bean.BillRangeBean;
import com.pizza.PizzaStore.business.bean.PizzaOrderBean;
import com.pizza.PizzaStore.service.PizzaService;

@Controller
public class ReportController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@RequestMapping(value = "LoadBillRangeReport")
	public ModelAndView loadDateRangeReportPage() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("OrderReport");
		mv.addObject("billRangeObj", new BillRangeBean());
		return mv;
	}
	
	@RequestMapping(value = "FetchRecordsWithinDateRange")
	public ModelAndView getorderDetails(@ModelAttribute("billRangeObj") BillRangeBean billRangeBean) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<PizzaOrderBean> list = pizzaService.getOrderDetails(billRangeBean.getFromPrice(), billRangeBean.getToPrice());
		mv.setViewName("OrderReport");
		mv.addObject("pizzaOrderList", list);
		return mv;
	}
	
	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleAllException(Exception exception) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("GereralisedExceptionHandlerPage");
		mv.addObject("message", exception.getStackTrace());
		return mv;
	}
}
