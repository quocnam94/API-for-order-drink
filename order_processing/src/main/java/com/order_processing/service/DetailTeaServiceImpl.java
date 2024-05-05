package com.order_processing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order_processing.dao.DetailTeaDao;
import com.order_processing.entity.DetailTea;

@Service
public class DetailTeaServiceImpl implements DetailTeaService {
	
	@Autowired
	private DetailTeaDao detailTeaDao;

	@Override
	public List<DetailTea> findByIds(List<Integer> theDetailTeaIds) {
		return detailTeaDao.findByIds(theDetailTeaIds);
	}

	@Override
	public void save(DetailTea detailTea) {
		detailTeaDao.save(detailTea);
	}

}
