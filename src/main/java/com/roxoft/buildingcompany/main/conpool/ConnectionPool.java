package main.java.com.roxoft.buildingcompany.main.conpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPool {
	private static final Logger lOGGER = LogManager.getLogger(ConnectionPool.class);
	private static ConnectionPool INSTANCE;
	private final static int CAPACITY = 3;

	private Connection connection;
	private BlockingQueue<Connection> pool = new ArrayBlockingQueue<>(CAPACITY);

	public static ConnectionPool getConnectionPool() {
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

	private Connection getConnection() {
		if (pool.isEmpty() && (Connection.getCountConnection() < CAPACITY)) {
			pool.add(new Connection());
			lOGGER.info("Connection was created and added into the pool ");
			tryTakeConnection();
			lOGGER.info("Connection was taken after creation");
		} else if (pool.isEmpty() && (Connection.getCountConnection() == CAPACITY)) {
			lOGGER.info("Please, waiting for");
		} else if (pool.size() > 0) {
			tryTakeConnection();
			lOGGER.info("Connection was taken");
		}
		return connection;
	}

	private void putBackConnection(Connection connection) {
		if (connection != null && (pool.size() < CAPACITY))
			pool.add(connection);
		lOGGER.info("Connection was put back ");
	}

	private void closeConnection() {
		lOGGER.info("Connection was closed ");
	}

	private void tryTakeConnection() {
		try {
			pool.take();
		} catch (InterruptedException e) {
			lOGGER.info(e.getMessage());
		}
	}

	public void work() {
		lOGGER.info(Thread.currentThread().getName() + " start work");
		getConnection();
		putBackConnection(connection);
		closeConnection();
		lOGGER.info(Thread.currentThread().getName() + " finish work");
	}

	public static int getCapacity() {
		return CAPACITY;
	}
}
