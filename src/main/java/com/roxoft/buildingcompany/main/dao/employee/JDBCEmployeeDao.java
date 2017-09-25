package com.roxoft.buildingcompany.main.dao.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.buildingcompany.Employee;
import com.roxoft.buildingcompany.main.dao.AbstractDao;

public class JDBCEmployeeDao extends AbstractDao implements IEmployeeDao {
	private static final Logger lOGGER = LogManager.getLogger(JDBCEmployeeDao.class);
	Connection connection;

	@Override
	public void add(Employee employee) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO  employees (NAME,SURNAME,JOB_TITLE,DATE_OF_BIRTH,ADDRESS_ID) VALUES (?,?,?,?,?)");
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getSurname());
			preparedStatement.setString(3, employee.getJobTitle());
			preparedStatement.setDate(4, employee.getDateOfBirth());
			preparedStatement.setInt(5, employee.getAddress());
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			close(connection);
			close(preparedStatement);
		}
	}

	@Override
	public Employee getById(int id) {
		PreparedStatement preparedStatement = null;
		Employee employee = new Employee();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT ID,NAME,SURNAME,JOB_TITLE,DATE_OF_BIRTH,ADDRESS_ID FROM employees WHERE ID=?");
			preparedStatement.setInt(1, id);
			ResultSet rs=preparedStatement.executeQuery();
			employee.setName(rs.);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getSurname());
			preparedStatement.setString(3, employee.getJobTitle());
			preparedStatement.setDate(4, employee.getDateOfBirth());
			preparedStatement.setInt(5, employee.getAddress());

		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			close(connection);
			close(preparedStatement);
		}
		return employee;
	}

	@Override
	public void update(Employee employee) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE  employees SET NAME=?, SURNAME=?, JOB_TITLE=?, DATE_OF_BIRTH=?, ADDRESS_ID=? WHERE ID=?");
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getSurname());
			preparedStatement.setString(3, employee.getJobTitle());
			preparedStatement.setDate(4, employee.getDateOfBirth());
			preparedStatement.set(5, employee.getAddress());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			close(connection);
			close(preparedStatement);
		}
	}

	@Override
	public void delete(Employee employee) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM  employees WHERE ID=?");
			preparedStatement.setInt(1, employee.get);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			close(connection);
			close(preparedStatement);
		}
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> employeeList = new ArrayList<>();
		Statement statement = null;
		ResultSet result = null;
		try {
			result = statement.executeQuery("SELECT ID,NAME,SURNAME,JOB_TITLE,DATE_OF_BIRTH,ADDRESS_ID FROM employees");
			statement = connection.createStatement();
			while (result.next()) {
				Employee employee = new Employee();
				employee.setId(result.getInt("ID"));
				employee.setName(result.getString("NAME"));
				employee.setSurname(result.getString("SURNAME"));
				employee.setJobTitle(result.getString("JOB_TITLE"));
				employee.setDateOfBirth(result.getDate("DATE_OF_BIRTH"));
				employee.setAddress(result.getInt("ADDRESS_ID"));
				employeeList.add(employee);
			}

		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			close(connection);
			close(statement);
			close(result);
		}
		return employeeList;
	}

	
}
