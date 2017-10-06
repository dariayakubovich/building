package com.roxoft.buildingcompany.main.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.roxoft.buildingcompany.main.address.Address;
import com.roxoft.buildingcompany.main.dao.idao.IAddressDao;
import com.roxoft.buildingcompany.main.dao.jdbc.AbstractDao;

public class MyBatisAddressDao extends AbstractDao implements IAddressDao {

	@Override
	public void add(Address address) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			session.insert("com.roxoft.buildingcompany.main.dao.mybatis.MyBatisAddressDao.add", address);
			session.commit();
		} finally {
			close(session);
		}
	}

	@Override
	public Address getById(int id) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			return session.selectOne("com.roxoft.buildingcompany.main.dao.mybatis.MyBatisAddressDao.getById", id);
		} finally {
			close(session);
		}
	}

	@Override
	public void update(Address address) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			session.update("com.roxoft.buildingcompany.main.dao.mybatis.MyBatisAddressDao.update", address);
			session.commit();
		} finally {
			close(session);
		}
	}

	@Override
	public void delete(Address address) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			session.delete("com.roxoft.buildingcompany.main.dao.mybatis.MyBatisAddressDao.delete", address);
			session.commit();
		} finally {
			close(session);
		}
	}

	@Override
	public List<Address> findAll() {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			return session.selectList("com.roxoft.buildingcompany.main.dao.mybatis.MyBatisAddressDao.findAll");
		} finally {
			close(session);
		}
	}
}
