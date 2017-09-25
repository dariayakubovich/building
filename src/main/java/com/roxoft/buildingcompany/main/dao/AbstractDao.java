package com.roxoft.buildingcompany.main.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.buildingcompany.main.dao.employee.JDBCEmployeeDao;

public abstract class AbstractDao {
	private static final Logger lOGGER = LogManager.getLogger(JDBCEmployeeDao.class);

	protected void close(AutoCloseable resourse) {
		if (resourse != null)
			try {
				resourse.close();
			} catch (Exception e) {
				lOGGER.error(e.getMessage());
			}
	}
}
