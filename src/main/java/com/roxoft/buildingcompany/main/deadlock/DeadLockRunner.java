package com.roxoft.buildingcompany.main.deadlock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class  DeadLockRunner{
	private static final Logger lOGGER = LogManager.getLogger(DeadLockRunner.class);

	public static void main(String[] args) {
		Object lock1 = new Object();
		Object lock2 = new Object();
		ThreadDead1 dead1 = new ThreadDead1(lock1, lock2);
		ThreadDead2 dead2 = new ThreadDead2(lock1, lock2);
		dead1.start();
		dead2.start();
		lOGGER.info("sasa");
	}

}
