package com.order_processing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order_processing.dao.TeasRepository;
import com.order_processing.entity.Teas;

@Service
public class TeaService {
	@Autowired
	private TeasRepository teasRepository;

	public List<Teas> findAll() {
		return teasRepository.findAll();
	}

	public Teas findById(int teaId) {
		return teasRepository.findById(teaId);
	}
}
