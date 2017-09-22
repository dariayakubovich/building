package main.java.com.roxoft.buildingcompany.main.conpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPool {
	private static final Logger lOGGER = LogManager.getLogger(ConnectionPool.class);
	private final static int CAPACITY = 3;
	private static ConnectionPool INSTANCE;

	private ConnectionPool() {

	}

	private BlockingQueue<Connection> pool = new ArrayBlockingQueue<>(CAPACITY);

	public static ConnectionPool getINSTANCE() {
		Lock l = new ReentrantLock();
		l.lock();
		try {
			if (INSTANCE == null) {
				INSTANCE = new ConnectionPool();
			}
			return INSTANCE;
		} finally {
			l.unlock();
		}
	}

	public Connection getConnection() throws InterruptedException {
		if (pool.isEmpty() && (Connection.getCountConnection() < CAPACITY)) {
			pool.add(new Connection());
		}
		return pool.take();
	}

	public void putBackConnection(Connection connection) {
		if (connection != null && (pool.size() < CAPACITY))
			pool.add(connection);
	}

	public void closeConnection() {
		lOGGER.info("Connection was closed ");
	}

	public static int getCapacity() {
		return CAPACITY;
	}
}
