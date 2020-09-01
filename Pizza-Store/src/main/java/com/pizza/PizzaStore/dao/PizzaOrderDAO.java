package com.pizza.PizzaStore.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pizza.PizzaStore.entity.PizzaOrderEntity;

@Repository
@Transactional
public interface PizzaOrderDAO extends CrudRepository<PizzaOrderEntity, Integer> {

}
