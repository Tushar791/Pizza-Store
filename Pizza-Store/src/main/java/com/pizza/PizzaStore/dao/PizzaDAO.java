package com.pizza.PizzaStore.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pizza.PizzaStore.entity.PizzaEntity;


@Repository
@Transactional
public interface PizzaDAO extends CrudRepository<PizzaEntity, Integer>{
	
	PizzaEntity findByPizzaId(int pizzaId);
	

}
