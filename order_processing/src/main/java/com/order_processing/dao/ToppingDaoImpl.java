package com.order_processing.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.order_processing.entity.Topping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class ToppingDaoImpl implements ToppingDao {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Topping> findByIds(List<Integer> theToppingIds) {
		TypedQuery<Topping> theQuery = entityManager.createQuery("from Topping where id in :theToppingIds", Topping.class);
		theQuery.setParameter("theToppingIds", theToppingIds);
		List<Topping> toppings = theQuery.getResultList();
		return toppings;
	}

}
