package com.order_processing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order_processing.dao.OrderRepository;
import com.order_processing.entity.Order;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public void save(Order order) {
		orderRepository.save(order);
	}
}
