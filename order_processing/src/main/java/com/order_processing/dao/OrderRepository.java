package com.order_processing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order_processing.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
