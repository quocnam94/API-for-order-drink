package com.order_processing.dao;

import java.util.List;

import com.order_processing.entity.DetailTea;

public interface DetailTeaDao {
	List<DetailTea> findByIds (List<Integer> theDetailTeaIds);

	void save(DetailTea detailTea);
}
