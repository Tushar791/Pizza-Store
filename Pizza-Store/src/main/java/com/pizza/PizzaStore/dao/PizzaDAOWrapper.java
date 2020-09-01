package com.pizza.PizzaStore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pizza.PizzaStore.business.bean.PizzaBean;
import com.pizza.PizzaStore.business.bean.PizzaOrderBean;
import com.pizza.PizzaStore.entity.PizzaEntity;
import com.pizza.PizzaStore.entity.PizzaOrderEntity;

@Repository
@Transactional
public class PizzaDAOWrapper {
	
	@Autowired
	private PizzaDAO pizzaDAO;
	@Autowired
	private PizzaOrderDAO pizzaOrderDAO;
	


	
	public List<PizzaOrderBean> getOrderDetails(Integer fromBill,Integer toBill) throws Exception{
		Iterable<PizzaOrderEntity> list = pizzaOrderDAO.findAll();
		List<PizzaOrderBean> listBean = new ArrayList<PizzaOrderBean>();
		for(PizzaOrderEntity entity: list) {
			if(entity.getBill()>= (Integer)fromBill && entity.getBill()<= (Integer)toBill) {
				listBean.add(pizzaOrderEntityToBean(entity));
			}
		}
		return listBean;
	}
	public PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaOrderBean)throws Exception {
		PizzaOrderEntity pizzaOrderEntity =  pizzaOrderBeanToEntity(pizzaOrderBean);
		pizzaOrderDAO.save(pizzaOrderEntity);
		pizzaOrderBean.setOrderId(pizzaOrderEntity.getOrderId());
		return pizzaOrderBean;
	}
	public List<PizzaBean> findAllPizzaDetails()throws Exception{
		Iterable<PizzaEntity> list = pizzaDAO.findAll();
		List<PizzaBean> listBean = new ArrayList<PizzaBean>();
		for(PizzaEntity entity : list) {
			listBean.add(pizzaEntityToBean(entity));
		}
		return listBean;
	}
	public Integer getPizzaPrice(Integer pizzaId)throws Exception {
		PizzaEntity entity = pizzaDAO.findByPizzaId(pizzaId);
		Integer price = entity.getPrice();
		return price;
	}
	
	
	public PizzaEntity pizzaBeanToEntity(PizzaBean bean) throws Exception{
		PizzaEntity entity = new PizzaEntity();
		entity.setPizzaId(bean.getPizzaId());
		entity.setPizzaName(bean.getPizzaName());
		entity.setPrice(bean.getPrice());
		return entity;
	}
	public PizzaBean pizzaEntityToBean(PizzaEntity entity)throws Exception {
		PizzaBean bean = new PizzaBean();
		bean.setPizzaId(entity.getPizzaId());
		bean.setPizzaName(entity.getPizzaName());
		bean.setPrice(entity.getPrice());
		return bean;
	}
	public PizzaOrderEntity pizzaOrderBeanToEntity(PizzaOrderBean bean) throws Exception {
		PizzaOrderEntity entity = new PizzaOrderEntity();
		entity.setBill(bean.getBill());
		entity.setContactNumber(bean.getContactNumber());
		entity.setCustomerName(bean.getCustomerName());
		entity.setNumberOfPiecesOrdered(bean.getNumberOfPiecesOrdered());
		entity.setOrderId(bean.getOrderId());
		entity.setPizzaId(bean.getPizzaId());
		return entity;
	}
	public PizzaOrderBean pizzaOrderEntityToBean(PizzaOrderEntity entity) throws Exception {
		PizzaOrderBean bean = new PizzaOrderBean();
		bean.setBill(entity.getBill());
		bean.setContactNumber(entity.getContactNumber());
		bean.setCustomerName(entity.getCustomerName());
		bean.setNumberOfPiecesOrdered(entity.getNumberOfPiecesOrdered());
		bean.setOrderId(entity.getOrderId());
		bean.setPizzaId(entity.getPizzaId());
		return bean;
		
	}

}
