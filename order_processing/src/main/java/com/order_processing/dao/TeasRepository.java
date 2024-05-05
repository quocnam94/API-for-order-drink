package com.order_processing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order_processing.entity.Teas;

@Repository
public interface TeasRepository extends JpaRepository<Teas, Integer> {
//	User findByEmail(String email);
	Teas findById(int id);
//    Boolean existsByEmail(String email);
    
}
