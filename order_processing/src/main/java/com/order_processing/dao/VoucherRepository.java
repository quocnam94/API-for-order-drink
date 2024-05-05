package com.order_processing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order_processing.entity.Voucher;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Integer> {
	Voucher findById(int id);
    
}
