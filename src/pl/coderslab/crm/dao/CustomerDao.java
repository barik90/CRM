package pl.coderslab.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.crm.model.Customer;

public class CustomerDao {
	public void saveToDB(Connection conn, Customer customer) throws SQLException {
		if (customer.getId() == 0) {
			String sql = "INSERT INTO customer(name, surname, dateOfBirth) VALUES (?, ?, ?)";
			String generatedColumns[] = { "ID" };
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql, generatedColumns);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getSurname());
			preparedStatement.setDate(3, customer.getDateOfBirth());
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				customer.setId(rs.getInt(1));
			}
		} else {
			String sql = "UPDATE customer SET name=?, surname=?, dateOfBirth=? where id=?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getSurname());
			preparedStatement.setDate(3, customer.getDateOfBirth());
			preparedStatement.setInt(4, customer.getId());
			preparedStatement.executeUpdate();
		}
	}

	static public Customer loadCustomerById(Connection conn, int id) throws SQLException {
		String sql = "SELECT * FROM customer where id=?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Customer loadedCustomer = new Customer();
			loadedCustomer.setId(resultSet.getInt("id"));
			loadedCustomer.setName(resultSet.getString("name"));
			loadedCustomer.setSurname(resultSet.getString("surname"));
			loadedCustomer.setDateOfBirth(resultSet.getDate("dateOfBirth"));
			return loadedCustomer;
		}
		return null;
	}

	static public Customer[] loadAllCustomer(Connection conn) throws SQLException {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		String sql = "SELECT * FROM	customer";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Customer loadedCustomer = new Customer();
			loadedCustomer.setId(resultSet.getInt("id"));
			loadedCustomer.setName(resultSet.getString("name"));
			loadedCustomer.setSurname(resultSet.getString("surname"));
			loadedCustomer.setDateOfBirth(resultSet.getDate("dateOfBirth"));
			customers.add(loadedCustomer);
		}
		Customer[] uArray = new Customer[customers.size()];
		uArray = customers.toArray(uArray);
		return uArray;
	}

	public void delete(Connection conn, int id) throws SQLException {
		if (id != 0) {
			String sql = "DELETE FROM customer WHERE id= ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			id = 0;
		}
	}
}
