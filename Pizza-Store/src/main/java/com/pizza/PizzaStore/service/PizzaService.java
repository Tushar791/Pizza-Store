package com.pizza.PizzaStore.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pizza.PizzaStore.business.bean.PizzaOrderBean;

@Service
public interface PizzaService {
	
	List<PizzaOrderBean> getOrderDetails(int fromBill, int toBill) throws Exception;
	PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaOrderBean) throws Exception;
	Map<Integer,String> findAllPizzaDetails() throws Exception;

}
