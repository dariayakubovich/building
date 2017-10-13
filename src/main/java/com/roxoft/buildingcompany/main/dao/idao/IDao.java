package com.roxoft.buildingcompany.main.dao.idao;

import java.util.List;

import com.roxoft.buildingcompany.main.dao.AbstractDao;

public interface IDao<T extends AbstractDao> {

	void add(T entity);

	T getById(int id);

	void update(T entity);

	void delete(T entity);

	List<T> findAll();
	}
