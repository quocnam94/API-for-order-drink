package com.order_processing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order_processing.entity.Topping;

@Repository
public interface ToppingRepository extends JpaRepository<Topping, Integer> {
	Topping findById(int id);

}
