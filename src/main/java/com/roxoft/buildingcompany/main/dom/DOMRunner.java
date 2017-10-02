package com.roxoft.buildingcompany.main.dom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DOMRunner {
	private static final Logger lOGGER = LogManager.getLogger( DOMRunner.class);
	public static void main(String[] args) {
		BuildCom domBuilder = new BuildCom();
		String path = "src\\main\\resources\\data1.xml";
		domBuilder.buildListBuilderWorkers(path);
		domBuilder.buildListMachineOperator(path);
		domBuilder.buildListEngineer(path);
		domBuilder.buildListManagerProject(path);
		domBuilder.buildListEconomist(path);
		domBuilder.buildListManagement(path);
		lOGGER.info(domBuilder.getBuilderWorkers().get(1).getAddress().getRegion().getRegionName());

	}

}
