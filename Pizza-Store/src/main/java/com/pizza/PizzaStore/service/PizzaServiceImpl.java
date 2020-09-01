package com.pizza.PizzaStore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.PizzaStore.business.bean.PizzaBean;
import com.pizza.PizzaStore.business.bean.PizzaOrderBean;
import com.pizza.PizzaStore.dao.PizzaDAOWrapper;

@Service
public class PizzaServiceImpl implements PizzaService {
	
	@Autowired
	PizzaDAOWrapper pizzaDAOWrapper;

	@Override
	public List<PizzaOrderBean> getOrderDetails(int fromBill, int toBill) throws Exception {
		List<PizzaOrderBean> list = pizzaDAOWrapper.getOrderDetails(fromBill, toBill);
		return list;
	}

	@Override
	public PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaOrderBean) throws Exception {
		int price = pizzaDAOWrapper.getPizzaPrice(pizzaOrderBean.getPizzaId());
		int bill =  pizzaOrderBean.getNumberOfPiecesOrdered()*price;
		pizzaOrderBean.setBill(bill);
		return pizzaDAOWrapper.addPizzaOrderDetails(pizzaOrderBean);
	}

	@Override
	public Map<Integer, String> findAllPizzaDetails() throws Exception {
		List<PizzaBean> pizzaList = pizzaDAOWrapper.findAllPizzaDetails();
		Map<Integer, String> pizzaMap = new HashMap<Integer, String>();
		for(PizzaBean item: pizzaList) {
			pizzaMap.put(item.getPizzaId(), item.getPizzaName());
		}
		return pizzaMap;
	}

}
