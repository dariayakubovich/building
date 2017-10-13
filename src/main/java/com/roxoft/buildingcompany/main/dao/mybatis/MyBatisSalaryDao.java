package com.roxoft.buildingcompany.main.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.roxoft.buildingcompany.main.dao.AbstractDao;
import com.roxoft.buildingcompany.main.dao.idao.ISalaryDao;
import com.roxoft.buildingcompany.main.salary.Salary;

public class MyBatisSalaryDao extends AbstractDao implements ISalaryDao {

	@Override
	public void add(Salary salary) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			session.insert("com.roxoft.buildingcompany.main.dao.mybatis.MyBatisSalaryDao.add", salary);
			session.commit();
		} finally {
			close(session);
		}
	}

	@Override
	public Salary getById(int id) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			return session.selectOne("com.roxoft.buildingcompany.main.dao.mybatis.MyBatisSalaryDao.getById", id);
		} finally {
			close(session);
		}
	}

	@Override
	public void update(Salary salary) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			session.update("com.roxoft.buildingcompany.main.dao.mybatis.MyBatisSalaryDao.update", salary);
			session.commit();
		} finally {
			close(session);
		}
	}

	@Override
	public void delete(Salary salary) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			session.delete("com.roxoft.buildingcompany.main.dao.mybatis.MyBatisSalaryDao.delete", salary);
			session.commit();
		} finally {
			close(session);
		}
	}

	@Override
	public List<Salary> findAll() {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			return session.selectList("com.roxoft.buildingcompany.main.dao.mybatis.MyBatisSalaryDao.findAll");
		} finally {
			close(session);
		}
	}
}
