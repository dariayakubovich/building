package com.roxoft.buildingcompany.main.dao.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.buildingcompany.main.address.Address;
import com.roxoft.buildingcompany.main.address.Region;
import com.roxoft.buildingcompany.main.dao.ConnectionPool;
import com.roxoft.buildingcompany.main.salary.Salary;

public abstract class AbstractDao {
	private static final Logger lOGGER = LogManager.getLogger(AbstractDao.class);
	public static SqlSessionFactory getSqlSessionFactory() {
		String resource = "src\\main\\resources\\mybatis.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			lOGGER.error(e.getMessage());
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}

	protected void close(AutoCloseable resourse) {
		if (resourse != null)
			try {
				resourse.close();
			} catch (Exception e) {
				lOGGER.error(e.getMessage());
			}
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			connection = ConnectionPool.getINSTANCE().getConnection();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		return connection;
	}

	protected String convertFromSQLDateToJAVADate(java.sql.Date sqlDate) {
		String date = null;
		;
		if (sqlDate != null) {
			java.util.Date javaDate = new Date(sqlDate.getTime());
			SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
			date = formatter.format(javaDate);
		}
		return date;
	}

	protected java.sql.Date convertFromJAVADateToSQLDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
		java.util.Date javaDate = formatFromStringToDate(date, formatter);
		java.sql.Date sqlDate = null;
		if (javaDate != null)
			sqlDate = new java.sql.Date(javaDate.getTime());
		return sqlDate;
	}

	protected Date formatFromStringToDate(String string, SimpleDateFormat formatter) {

		Date date = null;
		try {
			date = formatter.parse(string);
		} catch (ParseException e) {
			lOGGER.info(e.getMessage());
		}
		return date;
	}

	protected Address getAddressById(int address_id) {
		Address address = null;
		JDBCAddressDao addressDao = new JDBCAddressDao();
		List<Address> addressList = addressDao.findAll();
		switch (address_id) {
		case 1:
			address = addressList.get(0);
			break;
		case 2:
			address = addressList.get(1);
			break;
		case 3:
			address = addressList.get(2);
			break;
		case 4:
			address = addressList.get(3);
			break;
		case 5:
			address = addressList.get(4);
			break;
		default:
			lOGGER.error("Wrong address id!");
			break;
		}
		return address;
	}

	protected List<Salary> getSalaryFromListById(int emplId) {
		JDBCSalaryDao salaryDao = new JDBCSalaryDao();
		List<Salary> salaryList = salaryDao.findAll();
		List<Salary> salaryL = new ArrayList<>();
		for (int i = (3 * (emplId - 1)); i < ((3 * (emplId - 1)) + 3); i++) {
			salaryL.add(salaryList.get(i));
		}
		return salaryL;
	}
	protected Region getRegionById(int reg) {
		Region region = null;
		switch (reg) {
		case 1:
			region = Region.MINSK;
			break;
		case 2:
			region = Region.VITEBSK;
			break;
		case 3:
			region = Region.GOMEL;
			break;
		case 4:
			region = Region.GRODNO;
			break;
		case 5:
			region = Region.MOGILEV;
			break;
		case 6:
			region = Region.BREST;
			break;
		default:
			lOGGER.error("Wrong region id!");
			break;
		}
		return region;
	}

}
