package com.order_processing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order_processing.entity.Size;

@Repository
public interface SizeRepository extends JpaRepository<Size, Integer> {
	Size findById(int id);

}
