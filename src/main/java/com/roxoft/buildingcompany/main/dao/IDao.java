package com.roxoft.buildingcompany.main.dao;

import java.util.List;

public interface IDao<T extends AbstractDao> {

	void add(T entity);

	T getById(int id);

	void update(T entity);

	void delete(T entity);

	List<T> findAll();
}
