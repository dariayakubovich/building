package com.roxoft.buildingcompany.models.project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ManagerProject extends ProgectEmployee {
	private static final Logger lOGGER = LogManager.getLogger(ManagerProject.class);

	public void manageConstructorProject() {
		lOGGER.info("Manage construction projects");
	}

	@Override
	public void work() {
		manageConstructorProject();
	}

	@Override
	public void eat() {
		lOGGER.info("Have meal at the restaurant");
	}

}
