package pl.coderslab.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.crm.model.Vehicle;

public class VehicleDao {

	public void saveToDB(Connection conn, Vehicle vehicle) throws SQLException {
		if (vehicle.getId() == 0) {
			String sql = "INSERT INTO vehicle(model, mark, yearOfProduction, registrationNumber, dateOfTheNextTechnicalInspection, customer_id) VALUES (?, ?, ?, ?, ?, ?)";
			String generatedColumns[] = { "ID" };
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql, generatedColumns);
			preparedStatement.setString(1, vehicle.getModel());
			preparedStatement.setString(2, vehicle.getMark());
			preparedStatement.setDate(3, vehicle.getYearOfProduction());
			preparedStatement.setString(4, vehicle.getRegistrationNumber());
			preparedStatement.setDate(5, vehicle.getDateOfTheNextTechnicalInspection());
			preparedStatement.setInt(6, vehicle.getCustomer_id());
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				vehicle.setId(rs.getInt(1));
			}
		} else {
			String sql = "UPDATE vehicle SET model=?, mark=?, yearOfProduction=?, registrationNumber=?, dateOfTheNextTechnicalInspection=?, customer_id=? where id=?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, vehicle.getModel());
			preparedStatement.setString(2, vehicle.getMark());
			preparedStatement.setDate(3, vehicle.getYearOfProduction());
			preparedStatement.setString(4, vehicle.getRegistrationNumber());
			preparedStatement.setDate(5, vehicle.getDateOfTheNextTechnicalInspection());
			preparedStatement.setInt(6, vehicle.getCustomer_id());
			preparedStatement.setInt(7, vehicle.getId());
			preparedStatement.executeUpdate();
		}
	}

	static public Vehicle loadVehicleById(Connection conn, int id) throws SQLException {
		String sql = "SELECT * FROM vehicle where id=?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Vehicle loadedVehicle = new Vehicle();
			loadedVehicle.setId(resultSet.getInt("id"));
			loadedVehicle.setModel(resultSet.getString("model"));
			loadedVehicle.setMark(resultSet.getString("mark"));
			loadedVehicle.setYearOfProduction(resultSet.getDate("yearOfProduction"));
			loadedVehicle.setRegistrationNumber(resultSet.getString("registrationNumber"));
			loadedVehicle.setDateOfTheNextTechnicalInspection(resultSet.getDate("dateOfTheNextTechnicalInspection"));
			loadedVehicle.setCustomer_id(resultSet.getInt("customer_id"));
			return loadedVehicle;
		}
		return null;
	}

	static public Vehicle[] loadAllVehicle(Connection conn) throws SQLException {
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		String sql = "SELECT * FROM	vehicle";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Vehicle loadedVehicle = new Vehicle();
			loadedVehicle.setId(resultSet.getInt("id"));
			loadedVehicle.setModel(resultSet.getString("model"));
			loadedVehicle.setMark(resultSet.getString("mark"));
			loadedVehicle.setYearOfProduction(resultSet.getDate("yearOfProduction"));
			loadedVehicle.setRegistrationNumber(resultSet.getString("registrationNumber"));
			loadedVehicle.setDateOfTheNextTechnicalInspection(resultSet.getDate("dateOfTheNextTechnicalInspection"));
			loadedVehicle.setCustomer_id(resultSet.getInt("customer_id"));
			vehicles.add(loadedVehicle);
		}
		Vehicle[] uArray = new Vehicle[vehicles.size()];
		uArray = vehicles.toArray(uArray);
		return uArray;
	}

	public void delete(Connection conn, int id) throws SQLException {
		if (id != 0) {
			String sql = "DELETE FROM vehicle WHERE id= ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			id = 0;
		}
	}
}
