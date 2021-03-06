package com.roxoft.buildingcompany.main.deadlock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadDead2 extends Thread {
	private static final Logger lOGGER = LogManager.getLogger(ThreadDead1.class);
	private Object lock1;
	private Object lock2;

	ThreadDead2(Object lock1, Object lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}
	@Override
	public void run() {
		synchronized (lock2) {
			lOGGER.info("Thread-2 lock2");
		
	
		synchronized (lock1) {
			lOGGER.info("Thread-2 lock1");
			}
	}
	}

}
