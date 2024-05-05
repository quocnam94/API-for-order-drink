package com.order_processing.service;

import java.util.List;

import com.order_processing.entity.DetailTea;

public interface DetailTeaService {
	List<DetailTea> findByIds (List<Integer> theDetailTeaIds);

	void save(DetailTea detailTea);
}
