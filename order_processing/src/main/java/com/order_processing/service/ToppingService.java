package com.order_processing.service;

import java.util.List;

import com.order_processing.entity.Topping;

public interface ToppingService {
	List<Topping> findByIds (List<Integer> theToppingIds);
}
