package com.roxoft.buildingcompany.main.salary;

import com.roxoft.buildingcompany.main.dao.jdbc.AbstractDao;

public class Salary extends AbstractDao {
	private int id;
	private int salary;
	private String month;
	private String year;
	private int employee_id;

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Salary [id=" + id + ", salary=" + salary + ", month=" + month + ", year=" + year + ", employee_id="
				+ employee_id + "]";
	}

}