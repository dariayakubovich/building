package main.java.com.roxoft.buildingcompany.models.construction;

import main.java.com.roxoft.buildingcompany.Employee;
import main.java.com.roxoft.buildingcompany.main.IEat;

public abstract class ConstructionEmployee extends Employee implements IEat {
	private String colourHardHat;

	public String getColourHardHat() {
		return colourHardHat;
	}

	public void setColourHardHat(String colourHardHat) {
		this.colourHardHat = colourHardHat;
	}

}
