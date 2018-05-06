package pl.coderslab.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.crm.model.Employee;

public class EmployeeDao {

	public void saveToDB(Connection conn, Employee employee) throws SQLException {
		if (employee.getId() == 0) {
			String sql = "INSERT INTO employee(name, surname, address, phoneNumber, note, costOfManHour) VALUES (?, ?, ?, ?, ?, ?)";
			String generatedColumns[] = { "ID" };
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql, generatedColumns);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getSurname());
			preparedStatement.setString(3, employee.getAddress());
			preparedStatement.setString(4, employee.getPhoneNumber());
			preparedStatement.setString(5, employee.getNote());
			preparedStatement.setDouble(6, employee.getCostOfManHour());
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				employee.setId(rs.getInt(1));
			}
		} else {
			String sql = "UPDATE employee SET name=?, surname=?, address=?, phoneNumber=?, note=?, costOfManHour=? where id=?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getSurname());
			preparedStatement.setString(3, employee.getAddress());
			preparedStatement.setString(4, employee.getPhoneNumber());
			preparedStatement.setString(5, employee.getNote());
			preparedStatement.setDouble(6, employee.getCostOfManHour());
			preparedStatement.setInt(7, employee.getId());
			preparedStatement.executeUpdate();
		}
	}

	static public Employee loadEmployeeById(Connection conn, int id) throws SQLException {
		String sql = "SELECT * FROM employee where id=?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Employee loadedEmployee = new Employee();
			loadedEmployee.setId(resultSet.getInt("id"));
			loadedEmployee.setName(resultSet.getString("name"));
			loadedEmployee.setSurname(resultSet.getString("surname"));
			loadedEmployee.setAddress(resultSet.getString("address"));
			loadedEmployee.setPhoneNumber(resultSet.getString("phoneNumber"));
			loadedEmployee.setNote(resultSet.getString("note"));
			loadedEmployee.setCostOfManHour(resultSet.getDouble("costOfManHour"));
			return loadedEmployee;
		}
		return null;
	}

	static public Employee[] loadAllEmployee(Connection conn) throws SQLException {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT * FROM	employee";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Employee loadedEmployee = new Employee();
			loadedEmployee.setId(resultSet.getInt("id"));
			loadedEmployee.setName(resultSet.getString("name"));
			loadedEmployee.setSurname(resultSet.getString("surname"));
			loadedEmployee.setAddress(resultSet.getString("address"));
			loadedEmployee.setPhoneNumber(resultSet.getString("phoneNumber"));
			loadedEmployee.setNote(resultSet.getString("note"));
			loadedEmployee.setCostOfManHour(resultSet.getDouble("costOfManHour"));
			employees.add(loadedEmployee);
		}
		Employee[] uArray = new Employee[employees.size()];
		uArray = employees.toArray(uArray);
		return uArray;
	}

	public void delete(Connection conn, int id) throws SQLException {
		if (id != 0) {
			String sql = "DELETE FROM employee WHERE id= ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			id = 0;
		}
	}
}
