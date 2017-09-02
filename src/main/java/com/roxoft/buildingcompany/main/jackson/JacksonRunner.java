package main.java.com.roxoft.buildingcompany.main.jackson;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.core.JsonGenerationException;

public class JacksonRunner {
	private static final Logger lOGGER = LogManager.getLogger(JacksonRunner.class);

	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();
		try {
			File reader = new File("src\\main\\resources\\data.json");
			mapper.setDateFormat(new SimpleDateFormat("dd.MM.yyyy"));
			JSONBuildCom jacksonBuilder = mapper.readValue(reader, JSONBuildCom.class);
			lOGGER.info(jacksonBuilder.getManagement().get(0).toString());
			lOGGER.info(jacksonBuilder.getManagement().get(1).toString());
		} catch (JsonGenerationException e) {
			lOGGER.info(e.getMessage());
		} catch (JsonMappingException e) {
			lOGGER.info(e.getMessage());
		} catch (IOException e) {
			lOGGER.info(e.getMessage());

		}
	}
}
