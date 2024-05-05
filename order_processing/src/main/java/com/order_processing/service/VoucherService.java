package com.order_processing.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order_processing.dao.VoucherRepository;
import com.order_processing.entity.Voucher;

@Service
public class VoucherService {
	
	@Autowired
	private VoucherRepository voucherRepository;

	public Optional<Voucher> findById(Integer idVoucher) {
		return voucherRepository.findById(idVoucher);
	}
}
