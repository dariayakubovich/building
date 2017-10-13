package com.roxoft.buildingcompany.main.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.buildingcompany.main.address.Region;
import com.roxoft.buildingcompany.main.dao.ConnectionPool;

public abstract class AbstractDao {
	private static final Logger lOGGER = LogManager.getLogger(AbstractDao.class);
	public static SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis.xml";
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
			lOGGER.error(e1.getMessage());
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
