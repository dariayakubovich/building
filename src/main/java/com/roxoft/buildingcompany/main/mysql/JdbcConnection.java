package com.roxoft.buildingcompany.main.mysql;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JdbcConnection {
	private static final Logger lOGGER = LogManager.getLogger(JdbcConnection.class);

	protected static void close(AutoCloseable resourse) {
		if (resourse != null)
			try {
				resourse.close();
			} catch (Exception e) {
				lOGGER.error(e.getMessage());
			}
	}

	public static void main(String[] args) {

		Connection connection = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		} catch (SQLException e) {
			lOGGER.error("Driver not found");
		}
		Properties props = new Properties();
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
		String url = props.getProperty("jdbc.url");
		String user = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");
		ResultSet result = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement("SELECT * FROM employees where id > ? and id < ?");
			preparedStatement.setInt(1, 5);
			preparedStatement.setInt(2, 10);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				lOGGER.info("" + result.getRow() + "\t Employees_id " + result.getInt("id") + "\t"
						+ result.getString("name") + " " + result.getString("surname"));
			}

		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			close(connection);
			close(preparedStatement);
			close(result);
		}

	}
}
