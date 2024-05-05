package com.order_processing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order_processing.dao.CategoriesRepository;
import com.order_processing.entity.Categories;

@Service
public class CategoriesService {
	@Autowired
	private CategoriesRepository categoriesRepository;

	public List<Categories> findAll() {
		// TODO Auto-generated method stub
		return categoriesRepository.findAll();
	}
}
