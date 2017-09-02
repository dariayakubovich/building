package main.java.com.roxoft.buildingcompany.main.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import main.java.com.roxoft.buildingcompany.models.administration.Economist;
import main.java.com.roxoft.buildingcompany.models.administration.Management;
import main.java.com.roxoft.buildingcompany.models.construction.BuilderWorkers;
import main.java.com.roxoft.buildingcompany.models.construction.MachineOperator;
import main.java.com.roxoft.buildingcompany.models.project.Engineer;
import main.java.com.roxoft.buildingcompany.models.project.ManagerProject;

@XmlRootElement (name="buildingCompany")
public class XMLBuildCom {
	
	@XmlElement(name="builderWorkers")
	private List<BuilderWorkers> builderWorkersList;
	
	@XmlElement(name="machineOperator")
	private List<MachineOperator> machineOperatorList;
	
	@XmlElement(name="engineer")
	private List<Engineer> engineerList;
	
	@XmlElement(name="managerProject")
	private List<ManagerProject> managerProjectList;
	
	@XmlElement(name="economist")
	private List<Economist> economistList;
	
	@XmlElement(name="management")
	private List<Management> managementList;
	

	public XMLBuildCom() {
		super();
	}

	public List<BuilderWorkers> getBuilderWorkersList() {
		return builderWorkersList;
	}

	public List<MachineOperator> getMachineOperatorList() {
		return machineOperatorList;
	}

	public List<Engineer> getEngineerList() {
		return engineerList;
	}

	public List<ManagerProject> getManagerProjectList() {
		return managerProjectList;
	}

	public List<Economist> getEconomistList() {
		return economistList;
	}

	public List<Management> getManagementList() {
		return managementList;
	}
	
}