package com.roxoft.buildingcompany.models.administration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.buildingcompany.main.address.Address;

public class Management extends AdministrationEmployee {
	private static final Logger lOGGER = LogManager.getLogger(Management.class);
	private String numberWorkAuto;

	@Override
	public void work() {
		lOGGER.info("Manage");
	}

	public void work(int a) {
		int s = 5 * a;
		lOGGER.info(s);
	}

	public String getNumberWorkAuto() {
		return numberWorkAuto;
	}

	public void setNumberWorkAuto(String numberWorkAuto) {
		this.numberWorkAuto = numberWorkAuto;
	}

	@Override
	public String toString() {
		return "Full Name: " + getName() + " " + getSurname() + ". Job title: " + getJobTitle() + ". Address: "
				+ getAddress().getStreet() + " street, build " + getAddress().getBuilding() + ", "
				+ getAddress().getRegion().getRegionName() + ", " + getAddress().getCity() + ", " + Address.getCountry()
				+ ", " + getAddress().getZipcode() + "\n" + ", Work Auto - " + numberWorkAuto + ", Date of birth: "
				+ getDateOfBirth() + ", Date of starting work: " + getStartJob();

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Management other = (Management) obj;
		if (numberWorkAuto == null) {
			if (other.numberWorkAuto != null)
				return false;
		} else if (!numberWorkAuto.equals(other.numberWorkAuto))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numberWorkAuto == null) ? 0 : numberWorkAuto.hashCode());
		result = prime * result + ((getAddress().getBuilding() == null) ? 0 : getAddress().getBuilding().hashCode());
		result = prime * result + ((getAddress().getCity() == null) ? 0 : getAddress().getCity().hashCode());
		result = prime * result + ((getAddress().getRegion() == null) ? 0 : getAddress().getRegion().hashCode());
		result = prime * result + ((getAddress().getStreet() == null) ? 0 : getAddress().getStreet().hashCode());
		result = prime * result + ((getAddress().getZipcode() == null) ? 0 : getAddress().getZipcode().hashCode());
		result = prime * result + ((getJobTitle() == null) ? 0 : getJobTitle().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getSurname() == null) ? 0 : getSurname().hashCode());
		result = prime * result + ((getDateOfBirth() == null) ? 0 : getDateOfBirth().hashCode());
		return result;
	}

	@Override
	public void eat() {
		lOGGER.info("Have meal at the restaurant");
	}

}
