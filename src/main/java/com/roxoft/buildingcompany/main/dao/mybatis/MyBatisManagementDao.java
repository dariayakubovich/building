package com.roxoft.buildingcompany.main.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.roxoft.buildingcompany.main.dao.AbstractDao;
import com.roxoft.buildingcompany.main.dao.idao.IManagementDao;
import com.roxoft.buildingcompany.models.administration.Management;

public class MyBatisManagementDao extends AbstractDao implements IManagementDao {

	@Override
	public void add(Management management) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			session.insert("com.roxoft.buildingcompany.main.dao.mybatis.MyBatisManagementDao.add", management);
			session.commit();
		} finally {
			close(session);
		}
	}

	@Override
	public Management getById(int id) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			return session.selectOne("com.roxoft.buildingcompany.main.dao.mybatis.MyBatisManagementDao.getById", id);
		} finally {
			close(session);
		}
	}

	@Override
	public void update(Management management) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			session.update("com.roxoft.buildingcompany.main.dao.mybatis.MyBatisManagementDao.update", management);
			session.commit();
		} finally {
			close(session);
		}
	}

	@Override
	public void delete(Management management) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			session.delete("com.roxoft.buildingcompany.main.dao.mybatis.MyBatisManagementDao.delete", management);
			session.commit();
		} finally {
			close(session);
		}
	}

	@Override
	public List<Management> findAll() {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			return session.selectList("com.roxoft.buildingcompany.main.dao.mybatis.MyBatisManagementDao.findAll");
		} finally {
			close(session);
		}
	}
}
