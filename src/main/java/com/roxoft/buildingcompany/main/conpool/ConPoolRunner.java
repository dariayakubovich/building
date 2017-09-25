package com.roxoft.buildingcompany.main.conpool;

import java.sql.Connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.buildingcompany.main.Runner;

public class ConPoolRunner {
	private static final Logger lOGGER = LogManager.getLogger(ConPoolRunner.class);

	public static void main(String[] args) {
		ConnectionPool.getINSTANCE();
		Runner.repeat(ConnectionPool.getCapacity(), () -> {
			new Thread(() -> {
				try {
					//ConnectionPool.getINSTANCE().getConnection();
					Connection connection = null;
					ConnectionPool.getINSTANCE().putBackConnection(connection);
					//ConnectionPool.getINSTANCE().closeConnection();
				} catch (InterruptedException e) {
					lOGGER.error(e.getMessage());
				}
				
			}).start();
		});
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			lOGGER.error(e.getMessage());
		}
		
	}

}
