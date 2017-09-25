package com.roxoft.buildingcompany.models.construction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BuilderWorkers extends ConstructionEmployee {
	private static final Logger lOGGER = LogManager.getLogger(BuilderWorkers.class);
	private String kindOfConstructionWork;

	public void build() {
		lOGGER.info("Build");
	}

	@Override
	public void work() {
		build();
	}

	public String getKindOfConstructionWork() {
		return kindOfConstructionWork;
	}

	public void setKindOfConstructionWork(String kindOfConstructionWork) {
		this.kindOfConstructionWork = kindOfConstructionWork;
	}

	@Override
	public void eat() {
		lOGGER.info("Have meal at the mess hut");
	}
}