package com.order_processing.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.order_processing.entity.DetailTea;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class DetailTeaDaoImpl implements DetailTeaDao {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<DetailTea> findByIds(List<Integer> theDetailTeaIds) {
		TypedQuery<DetailTea> theQuery = entityManager.createQuery("from DetailTea where id in :theDetailTeaIds", DetailTea.class);
		theQuery.setParameter("theDetailTeaIds", theDetailTeaIds);
		List<DetailTea> detailTeas = theQuery.getResultList();
		return detailTeas;
	}

	@Override
	@Transactional
	public void save(DetailTea detailTea) {
		entityManager.merge(detailTea);
	}

}
