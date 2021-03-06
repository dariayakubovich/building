package com.roxoft.buildingcompany.main.jackson;

import java.util.List;

import com.roxoft.buildingcompany.models.administration.Economist;
import com.roxoft.buildingcompany.models.administration.Management;
import com.roxoft.buildingcompany.models.construction.BuilderWorkers;
import com.roxoft.buildingcompany.models.construction.MachineOperator;
import com.roxoft.buildingcompany.models.project.Engineer;
import com.roxoft.buildingcompany.models.project.ManagerProject;

public class JSONBuildCom {

	public JSONBuildCom() {
		super();
	}

	private List<BuilderWorkers> builderWorkers;

	private List<MachineOperator> machineOperator;

	private List<Engineer> engineer;

	private List<Economist> economist;

	private List<Management> management;
	private List<ManagerProject> managerProject;
	public List<BuilderWorkers> getBuilderWorkers() {
		return builderWorkers;
	}
	public List<MachineOperator> getMachineOperator() {
		return machineOperator;
	}
	public List<Engineer> getEngineer() {
		return engineer;
	}
	public List<Economist> getEconomist() {
		return economist;
	}
	public List<Management> getManagement() {
		return management;
	}
	public List<ManagerProject> getManagerProject() {
		return managerProject;
	}

	
}
