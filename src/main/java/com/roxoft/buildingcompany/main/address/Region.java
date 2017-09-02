package main.java.com.roxoft.buildingcompany.main.address;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="region")
@XmlEnum
public enum Region {
    MINSK("Minsk region"),
	VITEBSK("Vitebsk region"), 
	MOGILEV("Mogilev region"),
	BREST("Brest region"), 
	GRODNO("Grodno region"),
	GOMEL("Gomel region");

	private String regionName;

	private Region(String regionName) {
		this.regionName = regionName;
	}

	public String getRegionName() {
		return this.regionName;
	}

}
