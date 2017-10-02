package com.roxoft.buildingcompany.main.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.buildingcompany.main.address.Address;
import com.roxoft.buildingcompany.main.dao.jdbc.JDBCAddressDao;
import com.roxoft.buildingcompany.main.dao.jdbc.JDBCManagementDao;
import com.roxoft.buildingcompany.main.dao.jdbc.JDBCSalaryDao;
import com.roxoft.buildingcompany.main.salary.Salary;
import com.roxoft.buildingcompany.models.administration.Management;

public class DAORunner {
	private static final Logger lOGGER = LogManager.getLogger(DAORunner.class);

	public static void main(String[] args) {
		
		/*_________________________SALARY all methods work__________________________________*/
		
		
		JDBCSalaryDao salaryDao = new JDBCSalaryDao();
		/*
	    Salary salary = new Salary();
		salary.setEmployee_id(1);
		salary.setMonth("JANUARY");
		salary.setYear("2017");
		salary.setSalary(1000);
		salaryDao.add(salary);
	
		Salary salary1 = new Salary();
		salary1.setSalary(1000);
		salary1.setYear("2017");
		salary1.setMonth("JANUARY");
		salary1.setEmployee_id(1);
		salary1.setId(1);
		salaryDao.update(salary1);
		
		Salary salary2 = new Salary();
		salary2.setId(94);
		salaryDao.delete(salary2);
		
		lOGGER.info(salaryDao.getById(20));
		*/
		 List<Salary> salaryList = salaryDao.findAll();
		//salaryList.forEach(lOGGER::info);
		
		
		/*______________________________ADDRESS all methods work____________________________*/
		
		
		JDBCAddressDao addressDao = new JDBCAddressDao();
		/*
		Address address = new Address();
		address.setCountry1("BELARUS");
		address.setRegion_id(1);
	    address.setCity("MINSK");
		address.setStreet("MAIN");
		address.setBuilding("1");
		address.setZipcode("222222");
		addressDao.add(address);
		
		Address address1 = new Address();
		address1.setCountry1("BELARUS");
		address1.setRegion_id(1);
	    address1.setCity("MINSK");
		address1.setStreet("MAIN");8
		address1.setBuilding("1");
		address1.setZipcode("222222");
		address1.setId(6);
		addressDao.update(address1);
		
		Address address2 = new Address();
		address2.setId(6);
		addressDao.delete(address2);
		
		lOGGER.info(addressDao.getById(1));
		*/
		List<Address> addressList = addressDao.findAll();
		//addressList.forEach(lOGGER::info);
		
		
		/*______________________________MANAGEMENT____________________________*/
		
		JDBCManagementDao managementDao = new JDBCManagementDao();
	/*	Management management = new Management();
		management.setName("BOB");
		management.setSurname("DILAN");
	    management.setJobTitle("cleaner");
	    management.setDateOfBirth("02.10.2000");
		management.setAddress_id(1);
		management.setEmployee_id(1);
		management.setNumberWorkAuto("LADA");
		management.setAdministration_id(1);
		managementDao.add(management);
		
		Management management1 = new Management();
		management1.setName("BOB");
		management1.setSurname("DILAN");
	    management1.setJobTitle("CLEANER");
	    management1.setDateOfBirth("02.03.1989");
		management1.setAddress_id(5);
		management1.setId1(11);
		management1.setEmployee_id(3);
		management1.setId2(11);
		management1.setNumberWorkAuto("LADA1");
		management1.setAdministration_id(2);
		management1.setId3(3);
		managementDao.update(management1);
		
		Management management2 = new Management();
		management2.setId1(32);
		managementDao.delete(management2);
		*/
		
		List<Management> managementList = managementDao.findAll();
		managementList.forEach(lOGGER::info);
		//lOGGER.info(managementDao.getById(1));
		
		
	}

}
