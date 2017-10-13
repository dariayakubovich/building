package com.roxoft.buildingcompany.main.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.buildingcompany.main.address.Address;
import com.roxoft.buildingcompany.main.dao.jdbc.JDBCAddressDao;
import com.roxoft.buildingcompany.main.dao.jdbc.JDBCSalaryDao;
import com.roxoft.buildingcompany.main.dao.mybatis.MyBatisAddressDao;
import com.roxoft.buildingcompany.main.dao.mybatis.MyBatisSalaryDao;
import com.roxoft.buildingcompany.main.dao.services.ManagementService;
import com.roxoft.buildingcompany.main.salary.Salary;
import com.roxoft.buildingcompany.models.administration.Management;

public class RunnerDAO {
	private static final Logger lOGGER = LogManager.getLogger(RunnerDAO.class);

	public static void main(String[] args) {
		
		//JDBCSalaryDao salaryDao = new JDBCSalaryDao();
		//JDBCAddressDao addressDao = new JDBCAddressDao();
		
	/*	MyBatisSalaryDao salaryDao = new MyBatisSalaryDao();
		MyBatisAddressDao addressDao = new MyBatisAddressDao();*/
		ManagementService ms = new ManagementService();

		//SALARY
		
	/*	Salary salary = new Salary();
		salary.setEmployee_id(1);
		salary.setMonth("JANUARY");
		salary.setYear("2017");
		salary.setSalary(1000);

		Salary salary1 = new Salary();
		salary1.setSalary(1000);
		salary1.setYear("2017");
		salary1.setMonth("JANUARY");
		salary1.setEmployee_id(1);
		salary1.setId(1);

		Salary salary2 = new Salary();
		salary2.setId(94);

		salaryDao.add(salary);
		salaryDao.update(salary1);
		salaryDao.delete(salary2);
		lOGGER.info(salaryDao.getById(20));
		salaryDao.findAll().forEach(lOGGER::info);

		//ADDRESS
		
		Address address = new Address();
		address.setCountry1("BELARUS");
		address.setRegion_id(1);
		address.setCity("VITEBSK");
		address.setStreet("MAIN");
		address.setBuilding("1");
		address.setZipcode("222222");
		address.setReg("VITEBSK_REGION");

		Address address1 = new Address();
		address1.setCountry1("BELARUS");
		address1.setRegion_id(1);
		address1.setCity("MINSK");
		address1.setStreet("MAIN");
		address1.setBuilding("1");
		address1.setZipcode("222222");
		address1.setId(6);
		address1.setReg("VITEBSK_REGION");

		Address address2 = new Address();
		address2.setId(6);
		address2.setRegion_id(6);

		addressDao.add(address);
		addressDao.delete(address2);
		addressDao.update(address1);
		lOGGER.info(addressDao.getById(1));
		addressDao.findAll().forEach(lOGGER::info);

		//MANAGEMENT
		
		Management management = new Management();
		management.setName("BOB");
		management.setSurname("DILAN");
		management.setJobTitle("cleaner");
		management.setDateOfBirth1("02.10.2000");
		management.setAddress_id(1);
		management.setEmployee_id(1);
		management.setNumberWorkAuto("LADA");
		management.setAdministration_id(1);
		management.setAddress(address);
		management.setSalary(salary);

		Management management1 = new Management();
		management1.setName("BOB");
		management1.setSurname("DILAN");
		management1.setJobTitle("cleaner");
		management1.setDateOfBirth1("02.10.2000");
		management1.setAddress_id(11);
		management1.setEmployee_id(1);
		management1.setNumberWorkAuto("LADA5");
		management1.setAdministration_id(1);
		management1.setId1(1);
		management1.setId2(1);
		management1.setId3(1);
		management.setAddress(address1);
		management.setSalary(salary1);
		
		Management management2 = new Management();
		management.setAddress(address2);
		management.setSalary(salary2);
		
		ms.addManagement(management);
		ms.updateManagement(management1);
		ms.deleteManagement(management2);*/
		lOGGER.info(ms.getManagementById(5));
		ms.findAllManagement().forEach(lOGGER::info);

	}
}
