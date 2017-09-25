package com.roxoft.buildingcompany.models.project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Engineer extends ProgectEmployee {
	private static final Logger lOGGER = LogManager.getLogger(Engineer.class);
	private String specialization;

	public void drawing() {
		lOGGER.info("Create construction documentation");
	}

	@Override
	public void work() {
		drawing();
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public void eat() {
		lOGGER.info("Have meal at the refectory");
	}
}
