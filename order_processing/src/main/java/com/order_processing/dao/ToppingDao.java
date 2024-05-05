package com.order_processing.dao;

import java.util.List;

import com.order_processing.entity.Topping;

public interface ToppingDao {
	List<Topping> findByIds (List<Integer> theToppingIds);
}
