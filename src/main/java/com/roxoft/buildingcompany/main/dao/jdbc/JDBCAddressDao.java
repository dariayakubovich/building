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

import com.roxoft.buildingcompany.main.address.Address;
import com.roxoft.buildingcompany.main.dao.AbstractDao;
import com.roxoft.buildingcompany.main.dao.ConnectionPool;
import com.roxoft.buildingcompany.main.dao.idao.IAddressDao;

public class JDBCAddressDao extends AbstractDao implements IAddressDao {
	private static final Logger lOGGER = LogManager.getLogger(JDBCAddressDao.class);
	Connection connection;

	@Override
	public void add(Address address) {
		connection = getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement1 = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO  address (COUNTRY,REGION_ID,CITY,STREET,BUILDING,ZIPCODE) VALUES (?,?,?,?,?,?)");
			preparedStatement.setString(1, address.getCountry1());
			preparedStatement.setInt(2, address.getRegion_id());
			preparedStatement.setString(3, address.getCity());
			preparedStatement.setString(4, address.getStreet());
			preparedStatement.setString(5, address.getBuilding());
			preparedStatement.setString(6, address.getZipcode());
			preparedStatement.executeUpdate();
			preparedStatement1 = connection.prepareStatement("INSERT INTO  region (NAME) VALUE (?)");
			preparedStatement1.setString(1, address.getReg());
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			ConnectionPool.getINSTANCE().putBackConnection(connection);
			close(preparedStatement);
			close(preparedStatement1);
		}
	}

	@Override
	public void update(Address address) {
		connection = getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement1 = null;
		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE  address SET COUNTRY=?, REGION_ID=?, CITY=?, STREET=?,BUILDING=?, ZIPCODE=? WHERE ID=?");
			preparedStatement.setString(1, address.getCountry1());
			preparedStatement.setInt(2, address.getRegion_id());
			preparedStatement.setString(3, address.getCity());
			preparedStatement.setString(4, address.getStreet());
			preparedStatement.setString(5, address.getBuilding());
			preparedStatement.setString(6, address.getZipcode());
			preparedStatement.setInt(7, address.getId());
			preparedStatement.executeUpdate();
			preparedStatement1 = connection.prepareStatement("UPDATE  region set NAME=? WHERE ID=?");
			preparedStatement1.setString(1, address.getReg());
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			ConnectionPool.getINSTANCE().putBackConnection(connection);
			close(preparedStatement);
			close(preparedStatement1);
		}
	}

	@Override
	public Address getById(int id) {
		connection = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Address address = new Address();
		try {
			preparedStatement = connection
					.prepareStatement("SELECT * FROM ADDRESS A left join region R on A.REGION_ID=R.ID   WHERE A.ID=?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();
			if (result.next()) {
				address.setId(result.getInt("A.ID"));
				address.setCountry1(result.getString("A.COUNTRY"));
				address.setReg(result.getString("R.NAME"));
				address.setCity(result.getString("A.CITY"));
				address.setStreet(result.getString("A.STREET"));
				address.setBuilding(result.getString("A.BUILDING"));
				address.setZipcode(result.getString("A.ZIPCODE"));
			}
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			ConnectionPool.getINSTANCE().putBackConnection(connection);
			close(preparedStatement);
			close(result);
		}
		return address;
	}

	@Override
	public void delete(Address address) {
		connection = getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement1 = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM  address WHERE ID=?");
			preparedStatement.setInt(1, address.getId());
			preparedStatement.executeUpdate();
			preparedStatement1 = connection.prepareStatement("DELETE FROM  region WHERE ID=?");
			preparedStatement1.setInt(1, address.getRegion_id());
			preparedStatement1.executeUpdate();
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			ConnectionPool.getINSTANCE().putBackConnection(connection);
			close(preparedStatement);
			close(preparedStatement1);
		}
	}

	@Override
	public List<Address> findAll() {
		connection = getConnection();
		List<Address> addressList = new ArrayList<>();
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM ADDRESS A left join region R on A.REGION_ID=R.ID");
			while (result.next()) {
				Address address = new Address();
				address.setId(result.getInt("ID"));
				address.setCountry1(result.getString("COUNTRY"));
				address.setReg(result.getString("NAME"));
				address.setCity(result.getString("CITY"));
				address.setStreet(result.getString("STREET"));
				address.setBuilding(result.getString("BUILDING"));
				address.setZipcode(result.getString("ZIPCODE"));
				addressList.add(address);
			}
		} catch (SQLException e) {
			lOGGER.error(e.getMessage());
		} finally {
			ConnectionPool.getINSTANCE().putBackConnection(connection);
			close(statement);
			close(result);
		}
		return addressList;
	}

}
