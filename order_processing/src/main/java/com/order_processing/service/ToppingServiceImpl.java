package com.order_processing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order_processing.dao.ToppingDao;
import com.order_processing.entity.Topping;

@Service
public class ToppingServiceImpl implements ToppingService {
	
	@Autowired
	private ToppingDao toppingDao;

	@Override
	public List<Topping> findByIds(List<Integer> theToppingIds) {
		return toppingDao.findByIds(theToppingIds);
	}

}
