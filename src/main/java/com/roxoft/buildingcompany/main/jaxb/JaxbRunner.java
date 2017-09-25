package com.roxoft.buildingcompany.main.jaxb;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JaxbRunner {
	private static final Logger lOGGER = LogManager.getLogger(JaxbRunner.class);

	public static void main(String[] args) {
		try {
			JAXBContext context = JAXBContext.newInstance(XMLBuildCom.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			FileReader reader = new FileReader("src\\main\\resources\\data.xml");
			XMLBuildCom jaxbBuilder = (XMLBuildCom) unmarshaller.unmarshal(reader);
			lOGGER.info(jaxbBuilder.getManagementList().get(0).toString());
			lOGGER.info(jaxbBuilder.getManagementList().get(1).toString());
		} catch (JAXBException e) {
			lOGGER.info(e.getMessage());
		} catch (FileNotFoundException e) {
			lOGGER.info(e.getMessage());
		}
	}

}
