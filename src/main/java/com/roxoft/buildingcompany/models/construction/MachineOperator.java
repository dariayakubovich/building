package com.roxoft.buildingcompany.models.construction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MachineOperator extends ConstructionEmployee {
	private static final Logger lOGGER = LogManager.getLogger(MachineOperator.class);
	private String kindOfMachine;

	public void operateMachine() {

		lOGGER.info("Operate machine");
	}

	@Override
	public void work() {
		operateMachine();

	}

	public String getKindOfMachine() {
		return kindOfMachine;
	}

	public void setKindOfMachine(String kindOfMachine) {
		this.kindOfMachine = kindOfMachine;
	}

	@Override
	public void eat() {
		lOGGER.info("Have meal at the mess hut");
	}

}
