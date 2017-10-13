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
import com.roxoft.buildingcompany.main.dao.idao.ISalaryDao;
import com.roxoft.buildingcompany.main.salary.Salary;

public class JDBCSalaryDao extends AbstractDao implements ISalaryDao {
	private static final Logger lOGGER = LogManager.getLogger(JDBCSalaryDao.class);
	Connection connection;
	
	@Override
	public void add(Salary salary) {
       connection = getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement("INSERT INTO  salary (SALARY,YEAR,MONTH,EMPLOYEES_ID) VALUES (?,?,?,?)");
			preparedStatement.setInt(1, salary.getSalary());
			preparedStatement.setString(2, salary.getYear());
			preparedStatement.setString(3, salary.getMonth());
			preparedStatement.setInt(4, salary.getEmployee_id());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			ConnectionPool.getINSTANCE().putBackConnection(connection);
			close(preparedStatement);
		}
	}

	@Override
	public Salary getById(int id) {
		connection = getConnection();
		PreparedStatement preparedStatement = null;
		Salary salary = new Salary();
		try {
			preparedStatement = connection
					.prepareStatement("SELECT ID,SALARY,YEAR,MONTH,EMPLOYEES_ID FROM salary WHERE ID=?");
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			if(result.next()) {
				salary.setId(result.getInt("ID"));
				salary.setSalary(result.getInt("SALARY"));
				salary.setYear(result.getString("YEAR"));
				salary.setMonth(result.getString("MONTH"));
				salary.setEmployee_id(result.getInt("EMPLOYEES_ID"));
			}
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			ConnectionPool.getINSTANCE().putBackConnection(connection);
			close(preparedStatement);
		}
		return salary;
	}

	@Override
	public void update(Salary salary) {
		connection = getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement("UPDATE  salary SET SALARY=?, YEAR=?, MONTH=?, EMPLOYEES_ID=? WHERE ID=?");
			preparedStatement.setInt(1, salary.getSalary());
			preparedStatement.setString(2, salary.getYear());
			preparedStatement.setString(3, salary.getMonth());
			preparedStatement.setInt(4, salary.getEmployee_id());
			preparedStatement.setInt(5, salary.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			ConnectionPool.getINSTANCE().putBackConnection(connection);
			close(preparedStatement);
		}
	}

	@Override
	public void delete(Salary salary) {
		connection = getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM  salary WHERE ID=?");
			preparedStatement.setInt(1, salary.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			ConnectionPool.getINSTANCE().putBackConnection(connection);
			close(preparedStatement);
		}
	}

	@Override
	public List<Salary> findAll() {
		connection = getConnection();
		List<Salary> salaryList = new ArrayList<>();
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT ID,SALARY,YEAR,MONTH,EMPLOYEES_ID FROM salary");
			while (result.next()) {
				Salary salary = new Salary();
				salary.setId(result.getInt("ID"));
				salary.setSalary(result.getInt("SALARY"));
				salary.setYear(result.getString("YEAR"));
				salary.setMonth(result.getString("MONTH"));
				salary.setEmployee_id(result.getInt("EMPLOYEES_ID"));
				salaryList.add(salary);
			}
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			ConnectionPool.getINSTANCE().putBackConnection(connection);
			close(statement);
		}
		return salaryList;
	}
}
