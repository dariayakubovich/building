package com.roxoft.buildingcompany.main.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.buildingcompany.main.dao.AbstractDao;
import com.roxoft.buildingcompany.main.dao.ConnectionPool;
import com.roxoft.buildingcompany.main.dao.idao.IManagementDao;
import com.roxoft.buildingcompany.models.administration.Management;

public class JDBCManagementDao extends AbstractDao implements IManagementDao {
	private static final Logger lOGGER = LogManager.getLogger(JDBCManagementDao.class);
	Connection connection;

	@Override
	public void add(Management management) {
		connection = getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement1 = null;
		PreparedStatement preparedStatement2 = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO  employees (NAME,SURNAME,JOB_TITLE,DATE_OF_BIRTH,ADDRESS_ID) VALUES (?,?,?,?,?)");
			preparedStatement.setString(1, management.getName());
			preparedStatement.setString(2, management.getSurname());
			preparedStatement.setString(3, management.getJobTitle());
			preparedStatement.setDate(4, convertFromJAVADateToSQLDate(management.getDateOfBirth()));
			preparedStatement.setInt(5, management.getAddress_id());
			preparedStatement.executeUpdate();
			preparedStatement1 = connection
					.prepareStatement("INSERT INTO  administration_employees (EMPLOYEES_ID) VALUE (?)");
			preparedStatement1.setInt(1, management.getEmployee_id());
			preparedStatement1.executeUpdate();
			preparedStatement2 = connection
					.prepareStatement("INSERT INTO  management (WORK_AUTO, ADMINISTRATION_EMPLOYEES_ID) VALUE (?,?)");
			preparedStatement2.setString(1, management.getNumberWorkAuto());
			preparedStatement2.setInt(2, management.getAdministration_id());
			preparedStatement2.executeUpdate();
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			ConnectionPool.getINSTANCE().putBackConnection(connection);
			close(preparedStatement);
			close(preparedStatement1);
			close(preparedStatement2);
		}
	}

	@Override
	public Management getById(int id) {
		connection = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Management management = new Management();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM management m\r\n"
					+ "					LEFT JOIN administration_employees ae ON ae.ID = m.ADMINISTRATION_EMPLOYEES_ID\r\n"
					+ "					LEFT JOIN employees e ON e.ID = ae.EMPLOYEES_ID \r\n"
					+ "                    where e.id = ?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();
			if (result.next()) {
				management.setName(result.getString("e.NAME"));
				management.setSurname(result.getString("e.SURNAME"));
				management.setJobTitle(result.getString("e.JOB_TITLE"));
				management.setDateOfBirth1(convertFromSQLDateToJAVADate(result.getDate("e.DATE_OF_BIRTH")));
				management.setAddress_id(result.getInt("e.ADDRESS_ID"));
				management.setNumberWorkAuto(result.getString("m.WORK_AUTO"));
			}
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			ConnectionPool.getINSTANCE().putBackConnection(connection);
			close(preparedStatement);
			close(result);
		}
		return management;
	}

	@Override
	public void update(Management management) {
		connection = getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement1 = null;
		PreparedStatement preparedStatement2 = null;
		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE employees  SET NAME=?, SURNAME=?, JOB_TITLE=?,DATE_OF_BIRTH=?, ADDRESS_ID=?  WHERE ID=?");
			preparedStatement.setString(1, management.getName());
			preparedStatement.setString(2, management.getSurname());
			preparedStatement.setString(3, management.getJobTitle());
			preparedStatement.setDate(4, convertFromJAVADateToSQLDate(management.getDateOfBirth()));
			preparedStatement.setInt(5, management.getAddress_id());
			preparedStatement.setInt(6, management.getId1());
			preparedStatement.executeUpdate();
			preparedStatement1 = connection
					.prepareStatement("UPDATE administration_employees  SET EMPLOYEES_ID=? WHERE ID=?");
			preparedStatement1.setInt(1, management.getEmployee_id());
			preparedStatement1.setInt(2, management.getId2());
			preparedStatement1.executeUpdate();
			preparedStatement2 = connection.prepareStatement(
					"UPDATE management  SET WORK_AUTO=?, ADMINISTRATION_EMPLOYEES_ID=? WHERE ID=?");
			preparedStatement2.setString(1, management.getNumberWorkAuto());
			preparedStatement2.setInt(2, management.getAdministration_id());
			preparedStatement2.setInt(3, management.getId3());
			preparedStatement2.executeUpdate();
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			ConnectionPool.getINSTANCE().putBackConnection(connection);
			close(preparedStatement);
			close(preparedStatement1);
			close(preparedStatement2);
		}
	}

	@Override
	public void delete(Management management) {
		connection = getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement1 = null;
		PreparedStatement preparedStatement2 = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM  employees WHERE ID=?");
			preparedStatement.setInt(1, management.getId1());
			preparedStatement.executeUpdate();
			
			preparedStatement1 = connection.prepareStatement("DELETE FROM  administration_employees WHERE EMPLOYEES_ID=?");
			preparedStatement1.setInt(1, management.getId2());
			preparedStatement1.executeUpdate();
			
			preparedStatement2 = connection.prepareStatement("DELETE FROM  management WHERE ADMINISTRATION_EMPLOYEES_ID=?");
			preparedStatement2.setInt(1, management.getId3());
			preparedStatement2.executeUpdate();
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			ConnectionPool.getINSTANCE().putBackConnection(connection);
			close(preparedStatement);
			close(preparedStatement1);
			close(preparedStatement2);
		}
	}

	@Override
	public List<Management> findAll() {
		connection = getConnection();
		List<Management> managementList = new ArrayList<>();
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM management m"
					+ " LEFT JOIN administration_employees ae ON ae.ID = m.ADMINISTRATION_EMPLOYEES_ID"
					+ " LEFT JOIN employees e ON e.ID = ae.EMPLOYEES_ID ");
			while (result.next()) {
				Management management = new Management();
				management.setName(result.getString("e.NAME"));
				management.setSurname(result.getString("e.SURNAME"));
				management.setJobTitle(result.getString("e.JOB_TITLE"));
				management.setAddress_id(result.getInt("e.ADDRESS_ID"));
				management.setId1(result.getInt("e.ID"));
				management.setDateOfBirth1(convertFromSQLDateToJAVADate(result.getDate("e.DATE_OF_BIRTH")));
				management.setNumberWorkAuto(result.getString("m.WORK_AUTO"));
				managementList.add(management);
			}
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			ConnectionPool.getINSTANCE().putBackConnection(connection);
			close(statement);
			close(result);
		}
		return managementList;
	}

}
