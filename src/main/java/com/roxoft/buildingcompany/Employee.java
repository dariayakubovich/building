package main.java.com.roxoft.buildingcompany;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import main.java.com.roxoft.buildingcompany.main.jaxb.DateAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.roxoft.buildingcompany.main.address.Address;

/**
 * Abstract class Employee is the root of the building company's hierarchy. It
 * describes usual employee's parameters.
 * 
 * @author dyakubovich
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Employee {
	private static final Logger lOGGER = LogManager.getLogger(Employee.class);
	private String name;
	private String surname;
	private String jobTitle;
	private Address address;
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date dateOfBirth;

	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date startJob;

	public Employee() {
	}

	/**
	 * Describes working of employees.
	 */

	public abstract void work();

	/**
	 * Returns surname {@code String} of the Employee.
	 * 
	 * @return {@code String}
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets surname {@code String} of the Employee.
	 * 
	 * @param surname
	 *            {@code String}
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getStartJob() {
		return startJob;
	}

	public void setStartJob(Date startJob) {
		this.startJob = startJob;
	}

	/**
	 * Gets dateOfBirth {@code Date} and converts to dateOfBirthStr {@code String}
	 * using {@code SimpleDateFormat}.Date of birth is outputting in the following
	 * format: "dd-MMMM-yyyy". For example: "02-march-1989"
	 * 
	 * @see import java.util.Date
	 * @return dateOfBirthStr {@code String}
	 */

	public String getDateOfBirth() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
		String dateOfBirthStr = formatter.format(dateOfBirth);
		return dateOfBirthStr;
	}

	/**
	 * Sets dateOfBirthStr {@code String} and converts to dateOfBirth {@code Date}
	 * using {@code SimpleDateFormat}.You must input date of in the following
	 * format: "dd.MM.yyyy". For example: "02.03.1989"
	 * 
	 * @see #formatFromStringToDate(String, SimpleDateFormat)
	 * @see #getDateOfBirth()
	 * @see import java.util.Date
	 * @param {@code String} dateOfBirthStr
	 */

	public void setDateOfBirth(String dateOfBirthStr) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		Date date = formatFromStringToDate(dateOfBirthStr, formatter);
		this.dateOfBirth = date;
	}

	private Date formatFromStringToDate(String string, SimpleDateFormat formatter) {
		Date date = null;
		try {
			date = formatter.parse(string);
		} catch (ParseException e) {
			lOGGER.info(e.getMessage());
		}
		return date;
	}

	public String changeDateOfBirth(String dateOfBirthString) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
		Date dateOfBirthConvert = formatFromStringToDate(dateOfBirthString, formatter);
		c.setTime(dateOfBirthConvert);
		int numberDays = 5;
		c.add(c.DATE, numberDays);
		Date newDateOfBirth = c.getTime();
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMMM-yyyy");
		String newDateOfBirthString = formatter1.format(newDateOfBirth);
		lOGGER.info(dateOfBirthString + " + " + numberDays + " days = " + newDateOfBirthString);
		return newDateOfBirthString;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (jobTitle == null) {
			if (other.jobTitle != null)
				return false;
		} else if (!jobTitle.equals(other.jobTitle))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

}
