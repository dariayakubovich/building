package com.roxoft.buildingcompany.models.administration;

import com.roxoft.buildingcompany.Employee;
import com.roxoft.buildingcompany.main.IEat;

/**
 * 
 * @author dyakubovich
 *
 */

public abstract class AdministrationEmployee extends Employee implements IEat {
private int employee_id;
private int id2;


public int getEmployee_id() {
	return employee_id;
}

public void setEmployee_id(int employee_id) {
	this.employee_id = employee_id;
}

public int getId2() {
	return id2;
}

public void setId2(int id2) {
	this.id2 = id2;
}


}
