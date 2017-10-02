package com.roxoft.buildingcompany.main;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.RandomStringGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.buildingcompany.Employee;
import com.roxoft.buildingcompany.main.address.Address;
import com.roxoft.buildingcompany.main.address.Region;
import com.roxoft.buildingcompany.models.administration.AdministrationEmployee;
import com.roxoft.buildingcompany.models.administration.Economist;
import com.roxoft.buildingcompany.models.administration.Management;
import com.roxoft.buildingcompany.models.construction.BuilderWorkers;
import com.roxoft.buildingcompany.models.construction.MachineOperator;
import com.roxoft.buildingcompany.models.project.Engineer;
import com.roxoft.buildingcompany.models.project.ManagerProject;

public class Runner1 {
	private static final Logger lOGGER = LogManager.getLogger(Runner1.class);

	public static void workingEmployee(Employee employee) {
		employee.work();
	}

	public static void repeat(int n, Runnable r) {
		for (int i = 0; i < n; i++)
			r.run();
	}

	private static Date formatFromStringToDate(String string, SimpleDateFormat formatter) {
		Date date = null;
		try {
			date = formatter.parse(string);
		} catch (ParseException e) {
			lOGGER.info(e.getMessage());
		}
		return date;
	}

	public static void main(String[] args) throws AbsolutFilePathException {

		Employee management = new Management();
		management.setName("Ivan");
		management.setSurname("Petrov");
		management.setJobTitle("CEO");
		Address address = new Address();
		address.setRegion(Region.MINSK);
		address.setCity("Minsk");
		address.setStreet("Nemiga");
		address.setBuilding("15");
		address.setZipcode("220002");
		management.setAddress(address);
		((Management) management).setNumberWorkAuto("Porshe 666");
		management.setDateOfBirth("02.03.2000");
		Date date = formatFromStringToDate("15.09.2015", new SimpleDateFormat("dd.MM.yyyy"));
		management.setStartJob(date);

		lOGGER.info(management.getStartJob());

		Employee economist = new Economist();
		economist.setName("Elena");
		economist.setSurname("Petrova");
		economist.setJobTitle("Accountant");
		Address address1 = new Address();
		address1.setRegion(Region.MINSK);
		address1.setCity("Minsk");
		address1.setStreet("Kozlova");
		address1.setBuilding("48");
		address1.setZipcode("220202");
		economist.setAddress(address1);
		economist.setDateOfBirth("15.03.1989");
		Date date1 = formatFromStringToDate("15.09.2015", new SimpleDateFormat("dd.MM.yyyy"));
		economist.setStartJob(date1);

		Employee managerProject = new ManagerProject();
		managerProject.setName("Alex");
		managerProject.setSurname("Davidov");
		managerProject.setJobTitle("Progect manager");
		((ManagerProject) managerProject).setOfficeNumber(125);
		Address address2 = new Address();
		address2.setRegion(Region.MINSK);
		address2.setCity("Minsk");
		address2.setStreet("Frunze");
		address2.setBuilding("12");
		address2.setZipcode("220502");
		managerProject.setAddress(address2);
		managerProject.setDateOfBirth("19.10.1989");
		Date date2 = formatFromStringToDate("15.09.2015", new SimpleDateFormat("dd.MM.yyyy"));
		managerProject.setStartJob(date2);

		Employee engineer = new Engineer();
		engineer.setName("Max");
		engineer.setSurname("Black");
		engineer.setJobTitle("Senior engineer");
		((Engineer) engineer).setSpecialization("civil engineering");
		((Engineer) engineer).setOfficeNumber(306);
		Address address3 = new Address();
		address3.setRegion(Region.MINSK);
		address3.setCity("Minsk");
		address3.setStreet("Frunze");
		address3.setBuilding("46");
		address3.setZipcode("220502");
		engineer.setAddress(address3);
		engineer.setDateOfBirth("29.12.1989");
		Date date3 = formatFromStringToDate("15.09.2015", new SimpleDateFormat("dd.MM.yyyy"));
		engineer.setStartJob(date3);

		Employee machineOperator = new MachineOperator();
		machineOperator.setName("Mark");
		machineOperator.setSurname("Donald");
		machineOperator.setJobTitle("Gunior mashinist");
		((MachineOperator) machineOperator).setKindOfMachine("pillar crane");
		Address address4 = new Address();
		address4.setRegion(Region.MINSK);
		address4.setCity("Minsk");
		address4.setStreet("Lenina");
		address4.setBuilding("40");
		address4.setZipcode("220232");
		machineOperator.setAddress(address4);
		((MachineOperator) machineOperator).setColourHardHat("Orange");
		engineer.setDateOfBirth("08.11.1989");
		Date date4 = formatFromStringToDate("15.09.2015", new SimpleDateFormat("dd.MM.yyyy"));
		machineOperator.setStartJob(date4);

		Employee builderWorkers = new BuilderWorkers();
		builderWorkers.setName("Oleg");
		builderWorkers.setSurname("Titov");
		builderWorkers.setJobTitle("Bricklayer");
		Address address5 = new Address();
		address5.setRegion(Region.MINSK);
		address5.setCity("Minsk");
		address5.setStreet("Surganova");
		address5.setBuilding("96");
		address5.setZipcode("220520");
		builderWorkers.setAddress(address5);
		((BuilderWorkers) builderWorkers).setColourHardHat("Orange");
		((BuilderWorkers) builderWorkers).setKindOfConstructionWork("Civil Works Unit");
		builderWorkers.setDateOfBirth("04.12.1989");
		Date date5 = formatFromStringToDate("15.09.2015", new SimpleDateFormat("dd.MM.yyyy"));
		builderWorkers.setStartJob(date5);

		Employee management1 = new Management();
		AdministrationEmployee management2 = (AdministrationEmployee) management1;
		Management management3 = (Management) management2;
		AdministrationEmployee management4 = (AdministrationEmployee) management3;
		Employee management5 = (Employee) management4;

		management1.setName("Ivan");
		management1.setSurname("Petrov");
		management1.setJobTitle("CEO");
		Address address0 = new Address();
		address0.setRegion(Region.MINSK);
		address0.setCity("Minsk");
		address0.setStreet("Nemiga");
		address0.setBuilding("15");
		address0.setZipcode("220002");
		management1.setAddress(address0);
		((Management) management1).setNumberWorkAuto("Porshe 666");
		management1.setDateOfBirth("02.03.2000");

		lOGGER.info("Examples of methods toString(), hashCode() and equals() :");
		lOGGER.info(management.toString());
		lOGGER.info(management.hashCode());
		lOGGER.info(management1.hashCode());
		lOGGER.info(management.equals(management1));// true
		lOGGER.info("--------------------------------------------------------------------------------");
		((Management) management).work(5);
		management.work();
		lOGGER.info("--------------------------------------------------------------------------------");
		workingEmployee(management);
		workingEmployee(economist);
		workingEmployee(managerProject);
		workingEmployee(engineer);
		workingEmployee(machineOperator);
		workingEmployee(builderWorkers);
		lOGGER.info("--------------------------------------------------------------------------------");
		IEat management0 = new Management();
		IEat economist0 = new Economist();
		IEat managerProject0 = new ManagerProject();
		IEat engineer0 = new Engineer();
		IEat machineOperator0 = new MachineOperator();
		IEat builderWorkers0 = new BuilderWorkers();
		management0.eat();
		economist0.eat();
		managerProject0.eat();
		engineer0.eat();
		machineOperator0.eat();
		builderWorkers0.eat();
		lOGGER.info("--------------------------------------------------------------------------------");
		StringBuilder sb = new StringBuilder();
		sb.append(management.getName()).append(" ").append(management.getSurname()).append(", ")
				.append(economist.getName()).append(" ").append(economist.getSurname()).append(", ")
				.append(managerProject.getName()).append(" ").append(managerProject.getSurname()).append(", ")
				.append(engineer.getName()).append(" ").append(engineer.getSurname()).append(", ")
				.append(machineOperator.getName()).append(" ").append(machineOperator.getSurname()).append(", ")
				.append(builderWorkers.getName()).append(" ").append(builderWorkers.getSurname()).append(".");
		lOGGER.info(sb);

		StringBuffer sf = new StringBuffer();
		sf.append(management.getName()).append(" ").append(management.getSurname()).append(", ")
				.append(economist.getName()).append(" ").append(economist.getSurname()).append(", ")
				.append(managerProject.getName()).append(" ").append(managerProject.getSurname()).append(", ")
				.append(engineer.getName()).append(" ").append(engineer.getSurname()).append(", ")
				.append(machineOperator.getName()).append(" ").append(machineOperator.getSurname()).append(", ")
				.append(builderWorkers.getName()).append(" ").append(builderWorkers.getSurname()).append(".");
		lOGGER.info(sf);
		lOGGER.info("--------------------------------------------------------------------------------");
		management.getName().isEmpty(); // false
		StringUtils.isEmpty(management.getName()); // false
		StringUtils.isBlank(null); // true
		StringUtils.isBlank(""); // true
		StringUtils.isBlank(" "); // true
		StringUtils.isBlank("bob"); // false
		StringUtils.isBlank("  bob  "); // false

		StringUtils.isBlank(management.getName()); // false
		StringUtils.isEmpty(null); // true
		StringUtils.isEmpty(""); // true
		StringUtils.isEmpty(" "); // false
		StringUtils.isEmpty("bob"); // false
		StringUtils.isEmpty("  bob  "); // false

		String s = "Dasha is good at Java";
		lOGGER.info(s);
		lOGGER.info(s.substring(0, 5));
		lOGGER.info(s.substring(17));
		lOGGER.info("--------------------------------------------------------------------------------");
		File input = new File("src\\main\\resources\\input.txt");
		String txt = null;
		try {
			txt = FileUtils.readFileToString(input, "UTF-8");
		} catch (IOException e) {
			lOGGER.error(e.getMessage());
		}

		String filePath = "src\\main\\resources\\output.txt";
		File output = new File(filePath);
		String newtxt = txt.replaceAll("\\pP", "").toLowerCase();
		String[] words = newtxt.split(" ");
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < words.length; i++) {
			set.add(words[i] + ": " + StringUtils.countMatches(newtxt, words[i]));
		}

		try {
			FileUtils.writeLines(output, set);
		} catch (IOException e) {
			if (filePath.contains((":"))) {
				throw new AbsolutFilePathException("FilePath is uncorrect, it must be relative!!! ", e);
			}

		}

		management.changeDateOfBirth(management.getDateOfBirth());
		lOGGER.info("--------------------------------------------------------------------------------");

		Map<String, String> hashMap = new HashMap<>();
		hashMap.put(management.getName(), management.getJobTitle());
		hashMap.put(economist.getName(), economist.getJobTitle());
		hashMap.put(builderWorkers.getName(), builderWorkers.getJobTitle());
		hashMap.put(machineOperator.getName(), machineOperator.getJobTitle());
		hashMap.put(managerProject.getName(), managerProject.getJobTitle());
		hashMap.put(engineer.getName(), engineer.getJobTitle());
		lOGGER.info("Keys: " + hashMap.keySet());
		lOGGER.info("Values: " + hashMap.values());

		for (String key : hashMap.keySet()) {
			key.length();
		}
		for (String value : hashMap.values()) {
			value.concat(" - 1, ");
		}
		lOGGER.info("--------------------------------------------------------------------------------");
		for (Map.Entry<String, String> empl : hashMap.entrySet()) {
			lOGGER.info("Key: " + empl.getKey() + ", ");
			lOGGER.info("Value: " + empl.getValue());
		}
		lOGGER.info("--------------------------------------------------------------------------------");
		Employee[] m = new Employee[50];
		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
		List<Employee> list1 = new ArrayList<>();
		List<Employee> list2 = new LinkedList<>();

		for (int i = 0; i < m.length; i++) {
			m[i] = new Economist();
			String randomName = generator.generate(5);
			m[i].setName(randomName);
		}
		long startTimeAddArrayList = System.nanoTime();// addArray
		for (int i = 0; i < m.length; i++)
			list1.add(list1.size() / 2, m[i]);
		long finishTimeAddArrayList = System.nanoTime();
		long runTimeAddArrayList = finishTimeAddArrayList - startTimeAddArrayList;
		lOGGER.info("ArrayList was adding: " + runTimeAddArrayList);

		long startTimeRemoveArrayList = System.nanoTime();// removeArray
		repeat(m.length, () -> list1.remove(list1.size() / 2));
		long finishTimeRemoveArrayList = System.nanoTime();
		lOGGER.info("ArrayList was removing: " + (finishTimeRemoveArrayList - startTimeRemoveArrayList));

		long startTimeAddLinkedList = System.nanoTime();// addLinked
		for (int i = 0; i < m.length; i++)
			list2.add(list2.size() / 2, m[i]);
		long finishTimeAddLinkedList = System.nanoTime();
		lOGGER.info("LinkedList was adding: " + (finishTimeAddLinkedList - startTimeAddLinkedList));

		long startTimeRemoveLinkedList = System.nanoTime();// removeLinked
		repeat(m.length, () -> list2.remove(list2.size() / 2));
		long finishTimeRemoveLinkedList = System.nanoTime();
		lOGGER.info("LinkedList was removing: " + (finishTimeRemoveLinkedList - startTimeRemoveLinkedList));
		lOGGER.info("--------------------------------------------------------------------------------");
		set.stream().filter((sub) -> sub.contains("15")).forEach(lOGGER::info);
		lOGGER.info("--------------------------------------------------------------------------------");

	}

}

