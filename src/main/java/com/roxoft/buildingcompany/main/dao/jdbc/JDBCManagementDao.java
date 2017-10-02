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
		PreparedStatement preparedStatement1 = null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		ResultSet result = null;
		ResultSet result1 = null;
		ResultSet result2 = null;
		ResultSet result3 = null;
		Management management = new Management();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT ID,NAME,SURNAME,JOB_TITLE,DATE_OF_BIRTH,ADDRESS_ID FROM employees WHERE ID=?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();
			if (result.next()) {
				management.setName(result.getString("NAME"));
				management.setSurname(result.getString("SURNAME"));
				management.setJobTitle(result.getString("JOB_TITLE"));
				management.setDateOfBirth(convertFromSQLDateToJAVADate(result.getDate("DATE_OF_BIRTH")));
				management.setAddress(getAddressById(result.getInt("ADDRESS_ID")));
				management.setId1(result.getInt("ID"));
			}

			preparedStatement1 = connection
					.prepareStatement("SELECT ID, EMPLOYEES_ID FROM administration_employees WHERE ID=?");
			preparedStatement1.setInt(1, id);
			result1 = preparedStatement1.executeQuery();
			if (result1.next()) {
				management.setEmployee_id(result1.getInt("EMPLOYEES_ID"));
			}
			preparedStatement2 = connection
					.prepareStatement("SELECT ID,WORK_AUTO,ADMINISTRATION_EMPLOYEES_ID from management WHERE ID=?");
			preparedStatement2.setInt(1, id);
			result2 = preparedStatement2.executeQuery();
			if (result2.next()) {
				management.setNumberWorkAuto(result2.getString("WORK_AUTO"));
			management.setId3(result2.getInt("ADMINISTRATION_EMPLOYEES_ID"));
			}
			preparedStatement3 = connection
					.prepareStatement("SELECT ID,SALARY,YEAR,MONTH,EMPLOYEES_ID from salary WHERE ID=?");
			preparedStatement3.setInt(1, id);
			result3 = preparedStatement3.executeQuery();
			if (result3.next()) {
				management.setSalaryL(getSalaryFromListById(result3.getInt("EMPLOYEES_ID")));
			}
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			ConnectionPool.getINSTANCE().putBackConnection(connection);
			close(preparedStatement);
			close(preparedStatement1);
			close(preparedStatement2);
			close(preparedStatement3);
			close(result);
			close(result1);
			close(result2);
			close(result3);
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
			preparedStatement2 = connection
					.prepareStatement("UPDATE management  SET WORK_AUTO=?, ADMINISTRATION_EMPLOYEES_ID=? WHERE ID=?");
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
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM  employees WHERE ID=?");
			preparedStatement.setInt(1, management.getId1());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			ConnectionPool.getINSTANCE().putBackConnection(connection);
			close(preparedStatement);
		}
	}

	@Override
	public List<Management> findAll() {
		connection = getConnection();
		List<Management> managementList = new ArrayList<>();
		Statement statement = null;
		ResultSet result = null;
		ResultSet result1 = null;
		ResultSet result2 = null;
		ResultSet result3 = null;
		Management management = new Management();
		try {
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT ID,NAME,SURNAME,JOB_TITLE,DATE_OF_BIRTH,ADDRESS_ID FROM employees");
			while (result.next()) {
				management.setId1(result.getInt("ID"));
				management.setName(result.getString("NAME"));
				management.setSurname(result.getString("SURNAME"));
				management.setJobTitle(result.getString("JOB_TITLE"));
				management.setDateOfBirth(convertFromSQLDateToJAVADate(result.getDate("DATE_OF_BIRTH")));
				management.setAddress(getAddressById(result.getInt("ADDRESS_ID")));
			}
			result1 = statement.executeQuery("SELECT ID, EMPLOYEES_ID FROM administration_employees");
			while (result1.next()) {
				management.setId2(result1.getInt("ID"));
				management.setEmployee_id(result1.getInt("EMPLOYEES_ID"));
			}
			result2 = statement.executeQuery(" SELECT ID,WORK_AUTO,ADMINISTRATION_EMPLOYEES_ID from management");
			while (result2.next()) {
				management.setId3(result2.getInt("ID"));
				management.setNumberWorkAuto(result2.getString("WORK_AUTO"));
				management.setAdministration_id(result2.getInt("ADMINISTRATION_EMPLOYEES_ID"));
			}
			/*result3 = statement.executeQuery("SELECT ID,SALARY,YEAR,MONTH,EMPLOYEES_ID from salary");   виснет прога
			while (result3.next()) {
				management.setSalaryL(getSalaryFromListById(result3.getInt("EMPLOYEES_ID")));
			}*/
			managementList.add(management);
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			ConnectionPool.getINSTANCE().putBackConnection(connection);
			close(statement);
			close(result);
			close(result1);
			close(result2);
			close(result3);
		}
		return managementList;
	}

}
