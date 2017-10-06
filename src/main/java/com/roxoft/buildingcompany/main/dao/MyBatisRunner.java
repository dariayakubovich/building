package com.roxoft.buildingcompany.main.dao;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.buildingcompany.main.address.Address;
import com.roxoft.buildingcompany.main.dao.mybatis.MyBatisAddressDao;

public class MyBatisRunner {
	private static final Logger lOGGER = LogManager.getLogger(MyBatisRunner.class);


	public static void main(String[] args) {
		MyBatisAddressDao myBatisAddress = new MyBatisAddressDao();
		
		Address address = new Address();
		address.setCountry1("BELARUS");
		address.setRegion_id(1);
		address.setCity("MINSK");
		address.setStreet("MAIN");
		address.setBuilding("1");
		address.setZipcode("222222");
		myBatisAddress.add(address);
	}
}
