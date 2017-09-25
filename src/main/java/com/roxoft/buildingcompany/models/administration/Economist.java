package com.roxoft.buildingcompany.models.administration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Economist extends AdministrationEmployee {
	private static final Logger lOGGER = LogManager.getLogger(Economist.class);
	@Override
	public void work() {
		lOGGER.info("Count money");
	}

	@Override
	public void eat() {
		lOGGER.info("Have meal at the cafe");
	}

}
