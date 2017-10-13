package com.roxoft.buildingcompany.main.dao.services;

import java.util.ArrayList;
import java.util.List;

import com.roxoft.buildingcompany.main.dao.jdbc.JDBCAddressDao;
import com.roxoft.buildingcompany.main.dao.jdbc.JDBCManagementDao;
import com.roxoft.buildingcompany.main.dao.jdbc.JDBCSalaryDao;
import com.roxoft.buildingcompany.main.dao.mybatis.MyBatisAddressDao;
import com.roxoft.buildingcompany.main.dao.mybatis.MyBatisManagementDao;
import com.roxoft.buildingcompany.main.dao.mybatis.MyBatisSalaryDao;
import com.roxoft.buildingcompany.main.salary.Salary;
import com.roxoft.buildingcompany.models.administration.Management;

public class ManagementService {

	 JDBCManagementDao managementDao = new JDBCManagementDao();
	 JDBCSalaryDao salaryDao = new JDBCSalaryDao();
	 JDBCAddressDao addressDao = new JDBCAddressDao();
	 

/*	MyBatisManagementDao managementDao = new MyBatisManagementDao();
	MyBatisSalaryDao salaryDao = new MyBatisSalaryDao();
	MyBatisAddressDao addressDao = new MyBatisAddressDao();*/

	public void addManagement(Management management) {
		managementDao.add(management);
		salaryDao.add(management.getSalary());
		addressDao.add(management.getAddress());
	}

	public Management getManagementById(int id) {
		Management management = managementDao.getById(id);
		management.setAddress(addressDao.getById(management.getAddress_id()));
		management.setSalaryL(getSalaryListByEmployeeId(id));
		return management;
	}

	private List<Salary> getSalaryListByEmployeeId(int emplId) {
		List<Salary> salaryList = salaryDao.findAll();
		List<Salary> salaryL = new ArrayList<>();
		for (int i = 0; i < salaryList.size(); i++) {
			if (salaryList.get(i).getEmployee_id() == emplId) {
				salaryL.add(salaryList.get(i));
			}
		}
		return salaryL;
	}

	public void updateManagement(Management management) {
		managementDao.update(management);
		salaryDao.update(management.getSalary());
		addressDao.update(management.getAddress());
	}

	public void deleteManagement(Management management) {
		addressDao.delete(management.getAddress());
		managementDao.delete(management);
		salaryDao.delete(management.getSalary());
	}

	public List<Management> findAllManagement() {
		List<Management> managementList = managementDao.findAll();
		managementList.stream().forEach((m) -> m.setAddress(addressDao.getById(m.getAddress_id())));
		managementList.stream().forEach((m) -> m.setSalaryL(getSalaryListByEmployeeId(m.getId1())));
		return managementList;
	}

}
