package com.roxoft.buildingcompany.models.project;

import com.roxoft.buildingcompany.Employee;
import com.roxoft.buildingcompany.main.IEat;

/**
 * It describes specific parameters of employees, who work in project
 * organizations.
 * 
 * @author dyakubovich
 *
 */

public abstract class ProgectEmployee extends Employee implements IEat {
	private int officeNumber;

	public int getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(int officeNumber) {
		this.officeNumber = officeNumber;
	}

}
