package com.roxoft.buildingcompany.main.dom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.roxoft.buildingcompany.main.address.Address;
import com.roxoft.buildingcompany.main.address.Region;
import com.roxoft.buildingcompany.models.administration.Economist;
import com.roxoft.buildingcompany.models.administration.Management;
import com.roxoft.buildingcompany.models.construction.BuilderWorkers;
import com.roxoft.buildingcompany.models.construction.MachineOperator;
import com.roxoft.buildingcompany.models.project.Engineer;
import com.roxoft.buildingcompany.models.project.ManagerProject;

public class BuildCom {
	private List<BuilderWorkers> builderWorkers0;
	private List<MachineOperator> machineOperator0;
	private List<Engineer> engineer0;
	private List<ManagerProject> managerProject0;
	private List<Economist> economist0;
	private List<Management> management0;
	private DocumentBuilder docBuilder;
	private static final Logger lOGGER = LogManager.getLogger(BuildCom.class);

	public BuildCom() {
		this.builderWorkers0 = new ArrayList<BuilderWorkers>();
		this.machineOperator0 = new ArrayList<MachineOperator>();
		this.engineer0 = new ArrayList<Engineer>();
		this.managerProject0 = new ArrayList<ManagerProject>();
		this.economist0 = new ArrayList<Economist>();
		this.management0 = new ArrayList<Management>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			lOGGER.error(e.getMessage());
		}
	}

	public List<BuilderWorkers> getBuilderWorkers() {
		return builderWorkers0;
	}

	public List<MachineOperator> getMachineOperator() {
		return machineOperator0;
	}

	public List<Engineer> getEngineer() {
		return engineer0;
	}

	public List<ManagerProject> getManagerProject() {
		return managerProject0;
	}

	public List<Economist> getEconomist() {
		return economist0;
	}

	public List<Management> getManagement() {
		return management0;
	}

	public DocumentBuilder getDocBuilder() {
		return docBuilder;
	}

	public void buildListBuilderWorkers(String fileName) {
		Document doc = null;
		try {
			doc = docBuilder.parse(fileName);
			Element root = doc.getDocumentElement();
			NodeList builderWorkersList = root.getElementsByTagName("builderWorkers");
			for (int i = 0; i < builderWorkersList.getLength(); i++) {
				Element builderWorkersElement = (Element) builderWorkersList.item(i);
				BuilderWorkers builderWorker = buildBuilderWorker(builderWorkersElement);
				builderWorkers0.add(builderWorker);
			}
		} catch (SAXException e) {
			lOGGER.error(e.getMessage());
		} catch (IOException e) {
			lOGGER.error(e.getMessage());
		}
	}

	public void buildListMachineOperator(String fileName) {
		Document doc = null;
		try {
			doc = docBuilder.parse(fileName);
			Element root = doc.getDocumentElement();
			NodeList machineOperatorList = root.getElementsByTagName("machineOperator");
			for (int i = 0; i < machineOperatorList.getLength(); i++) {
				Element machineOperatorElement = (Element) machineOperatorList.item(i);
				MachineOperator machineOperator = buildMachineOperator(machineOperatorElement);
				machineOperator0.add(machineOperator);
			}
		} catch (SAXException e) {
			lOGGER.error(e.getMessage());
		} catch (IOException e) {
			lOGGER.error(e.getMessage());
		}

	}

	public void buildListEngineer(String fileName) {
		Document doc = null;
		try {
			doc = docBuilder.parse(fileName);
			Element root = doc.getDocumentElement();
			NodeList engineerList = root.getElementsByTagName("engineer");
			for (int i = 0; i < engineerList.getLength(); i++) {
				Element engineerElement = (Element) engineerList.item(i);
				Engineer engineer = buildEngineer(engineerElement);
				engineer0.add(engineer);
			}
		} catch (SAXException e) {
			lOGGER.error(e.getMessage());
		} catch (IOException e) {
			lOGGER.error(e.getMessage());
		}

	}

	public void buildListManagerProject(String fileName) {
		Document doc = null;
		try {
			doc = docBuilder.parse(fileName);
			Element root = doc.getDocumentElement();
			NodeList managerProjectList = root.getElementsByTagName("managerProject");
			for (int i = 0; i < managerProjectList.getLength(); i++) {
				Element managerProjectElement = (Element) managerProjectList.item(i);
				ManagerProject managerProject = buildManagerProject(managerProjectElement);
				managerProject0.add(managerProject);
			}
		} catch (SAXException e) {
			lOGGER.error(e.getMessage());
		} catch (IOException e) {
			lOGGER.error(e.getMessage());
		}

	}

	public void buildListEconomist(String fileName) {
		Document doc = null;
		try {
			doc = docBuilder.parse(fileName);
			Element root = doc.getDocumentElement();
			NodeList economistList = root.getElementsByTagName("economist");
			for (int i = 0; i < economistList.getLength(); i++) {
				Element economistElement = (Element) economistList.item(i);
				Economist economist = buildEconomist(economistElement);
				economist0.add(economist);
			}
		} catch (SAXException e) {
			lOGGER.error(e.getMessage());
		} catch (IOException e) {
			lOGGER.error(e.getMessage());
		}

	}

	public void buildListManagement(String fileName) {
		Document doc = null;
		try {
			doc = docBuilder.parse(fileName);
			Element root = doc.getDocumentElement();
			NodeList managementList = root.getElementsByTagName("management");
			for (int i = 0; i < managementList.getLength(); i++) {
				Element managementElement = (Element) managementList.item(i);
				Management management = buildManagement(managementElement);
				management0.add(management);
			}
		} catch (SAXException e) {
			lOGGER.error(e.getMessage());
		} catch (IOException e) {
			lOGGER.error(e.getMessage());
		}

	}

	private BuilderWorkers buildBuilderWorker(Element builderWorkersElement) {
		BuilderWorkers builderWorker = new BuilderWorkers();
		builderWorker.setName(getElementTextContent(builderWorkersElement, "name").trim());
		builderWorker.setSurname(getElementTextContent(builderWorkersElement, "surname").trim());
		builderWorker.setJobTitle(getElementTextContent(builderWorkersElement, "jobTitle").trim());
		builderWorker.setKindOfConstructionWork(
				getElementTextContent(builderWorkersElement, "kindOfConstructionWork").trim());
		builderWorker.setColourHardHat(getElementTextContent(builderWorkersElement, "colourHardHat").trim());
		builderWorker.setDateOfBirth(getElementTextContent(builderWorkersElement, "dateOfBirth").trim());
		Address address = new Address();
		Element addressElement = (Element) builderWorkersElement.getElementsByTagName("address").item(0);
		buildAddress(address, addressElement);
		builderWorker.setAddress(address);
		return builderWorker;
	}

	private MachineOperator buildMachineOperator(Element machineOperatorElement) {
		MachineOperator machineOperator = new MachineOperator();
		machineOperator.setName(getElementTextContent(machineOperatorElement, "name").trim());
		machineOperator.setSurname(getElementTextContent(machineOperatorElement, "surname").trim());
		machineOperator.setJobTitle(getElementTextContent(machineOperatorElement, "jobTitle").trim());
		machineOperator.setKindOfMachine(getElementTextContent(machineOperatorElement, "kindOfMachine").trim());
		machineOperator.setColourHardHat(getElementTextContent(machineOperatorElement, "colourHardHat").trim());
		machineOperator.setDateOfBirth(getElementTextContent(machineOperatorElement, "dateOfBirth").trim());
		Address address = new Address();
		Element addressElement = (Element) machineOperatorElement.getElementsByTagName("address").item(0);
		buildAddress(address, addressElement);
		machineOperator.setAddress(address);
		return machineOperator;
	}

	private Engineer buildEngineer(Element engineerElement) {
		Engineer engineer = new Engineer();
		engineer.setName(getElementTextContent(engineerElement, "name").trim());
		engineer.setSurname(getElementTextContent(engineerElement, "surname").trim());
		engineer.setJobTitle(getElementTextContent(engineerElement, "jobTitle").trim());
		engineer.setSpecialization(getElementTextContent(engineerElement, "specialization").trim());
		engineer.setDateOfBirth(getElementTextContent(engineerElement, "dateOfBirth").trim());
		Address address = new Address();
		Element addressElement = (Element) engineerElement.getElementsByTagName("address").item(0);
		buildAddress(address, addressElement);
		engineer.setAddress(address);
		return engineer;
	}

	private ManagerProject buildManagerProject(Element managerProjectElement) {
		ManagerProject managerProject = new ManagerProject();
		managerProject.setName(getElementTextContent(managerProjectElement, "name").trim());
		managerProject.setSurname(getElementTextContent(managerProjectElement, "surname").trim());
		managerProject.setJobTitle(getElementTextContent(managerProjectElement, "jobTitle").trim());
		managerProject.setDateOfBirth(getElementTextContent(managerProjectElement, "dateOfBirth").trim());
		Address address = new Address();
		Element addressElement = (Element) managerProjectElement.getElementsByTagName("address").item(0);
		buildAddress(address, addressElement);
		managerProject.setAddress(address);
		return managerProject;
	}

	private Economist buildEconomist(Element economistElement) {
		Economist economist = new Economist();
		economist.setName(getElementTextContent(economistElement, "name").trim());
		economist.setSurname(getElementTextContent(economistElement, "surname").trim());
		economist.setJobTitle(getElementTextContent(economistElement, "jobTitle").trim());
		economist.setDateOfBirth(getElementTextContent(economistElement, "dateOfBirth").trim());
		Address address = new Address();
		Element addressElement = (Element) economistElement.getElementsByTagName("address").item(0);
		buildAddress(address, addressElement);
		economist.setAddress(address);
		return economist;
	}

	private Management buildManagement(Element managementElement) {
		Management management = new Management();
		management.setName(getElementTextContent(managementElement, "name").trim());
		management.setSurname(getElementTextContent(managementElement, "surname").trim());
		management.setJobTitle(getElementTextContent(managementElement, "jobTitle").trim());
		management.setDateOfBirth(getElementTextContent(managementElement, "dateOfBirth").trim());
		management.setNumberWorkAuto(getElementTextContent(managementElement, "numberWorkAuto").trim());
		Address address = new Address();
		Element addressElement = (Element) managementElement.getElementsByTagName("address").item(0);
		buildAddress(address, addressElement);
		management.setAddress(address);
		return management;
	}

	private void buildAddress(Address address, Element addressElement) {
		address.setRegion(getRegionByName(getElementTextContent(addressElement, "region").trim()));
		address.setCity(getElementTextContent(addressElement, "city").trim());
		address.setBuilding(getElementTextContent(addressElement, "building").trim());
		address.setZipcode(getElementTextContent(addressElement, "zipcode").trim());
	}

	private Region getRegionByName(String reg) {
		Region region = null;
		switch (reg) {
		case "Minsk_region":
			region = Region.MINSK;
			break;
		case "Vitebsk_region":
			region = Region.VITEBSK;
			break;
		case "Brest_region":
			region = Region.BREST;
			break;
		case "Gomel_region":
			region = Region.GOMEL;
			break;
		case "Mogilev_region":
			region = Region.MOGILEV;
			break;
		case "Grodno_region":
			region = Region.GRODNO;
			break;
		default:
			lOGGER.error("Wrong region name!");
			break;
		}
		return region;
	}

	private static String getElementTextContent(Element element, String elementName) {
		NodeList nList = element.getElementsByTagName(elementName);
		Node node = nList.item(0);
		String text = node.getTextContent();
		return text;
	}
}
