package com.order_processing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order_processing.dao.SizeRepository;
import com.order_processing.entity.Size;

@Service
public class SizeService {
	@Autowired
	private SizeRepository sizeRepository;

	public List<Size> findAll() {
		// TODO Auto-generated method stub
		return sizeRepository.findAll();
	}

	public Optional<Size> findById(Integer idSize) {
		// TODO Auto-generated method stub
		return sizeRepository.findById(idSize);
	}
}
