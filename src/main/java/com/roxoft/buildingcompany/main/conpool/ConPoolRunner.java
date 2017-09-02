package main.java.com.roxoft.buildingcompany.main.conpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.roxoft.buildingcompany.main.Runner;

public class ConPoolRunner {
	private static final Logger lOGGER = LogManager.getLogger(ConPoolRunner.class);

	public static void main(String[] args) {
		ConnectionPool.getConnectionPool();
		Runner.repeat(ConnectionPool.getCapacity(), () -> {
			new Thread(() -> {
				ConnectionPool.getConnectionPool().work();
			}).start();
		});
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			lOGGER.error(e.getMessage());
		}
		
	}

}
