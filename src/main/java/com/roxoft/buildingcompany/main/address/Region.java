package com.roxoft.buildingcompany.main.address;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "region")
@XmlEnum
public enum Region {
	MINSK("Minsk region", 1), VITEBSK("Vitebsk region", 2), MOGILEV("Mogilev region", 5), BREST("Brest region",
			6), GRODNO("Grodno region", 4), GOMEL("Gomel region", 3);

	private String regionName;
	private int id;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private Region(String regionName, int id) {
		this.regionName = regionName;
		this.id = id;
	}

	public String getRegionName() {
		return this.regionName;
	}
}
