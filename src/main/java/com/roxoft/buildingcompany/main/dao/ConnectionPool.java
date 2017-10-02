package com.roxoft.buildingcompany.main.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPool {
	private static final Logger lOGGER = LogManager.getLogger(ConnectionPool.class);
	private final static int CAPACITY = 3;
	private int CountConnection;
	private static ConnectionPool INSTANCE;
	private String url;
	private String user;
	private String password;
	private Properties props;
	private Connection connection = null;

	private ConnectionPool() {
		props = new Properties();
		FileInputStream env = null;
		try {
			env = new FileInputStream("src\\main\\resources\\env.properties");
		} catch (FileNotFoundException e2) {
			lOGGER.error(e2.getMessage());
		}
		try {
			props.load(env);
		} catch (IOException e2) {
			lOGGER.error(e2.getMessage());
		} finally {
			close(env);
		}
		url = props.getProperty("jdbc.url");
		user = props.getProperty("jdbc.username");
		password = props.getProperty("jdbc.password");
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

	private Connection initiateConnection() {
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		}
		return connection;
	}

	public Connection getConnection() throws InterruptedException {
		if (pool.isEmpty() && (CountConnection < CAPACITY)) {
			pool.add(initiateConnection());
			CountConnection++;
		}
		return pool.take();
	}

	public void putBackConnection(Connection connection) {
		if (connection != null)
			pool.add(connection);
	}

	public static int getCapacity() {
		return CAPACITY;
	}

	protected void close(AutoCloseable resourse) {
		if (resourse != null)
			try {
				resourse.close();
			} catch (Exception e) {
				lOGGER.error(e.getMessage());
			}
	}
}
