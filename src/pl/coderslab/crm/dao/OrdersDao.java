package pl.coderslab.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.crm.model.Orders;

public class OrdersDao {

	public void saveToDB(Connection conn, Orders orders) throws SQLException {
		if (orders.getId() == 0) {
			String sql = "INSERT INTO orders(dateOfAcceptRepair, plannedStartDateOfTheRepair, dateOfRepairStarted, employee_id, descriptionOfTheProblem, descriptionRepair, status_id, vehicle_id, repairCost, partsCost, costOfManHour, quantityOfManHour) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			String generatedColumns[] = { "ID" };
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql, generatedColumns);
			preparedStatement.setDate(1, orders.getDateOfAcceptRepair());
			preparedStatement.setDate(2, orders.getPlannedStartDateOfTheRepair());
			preparedStatement.setDate(3, orders.getDateOfRepairStarted());
			preparedStatement.setInt(4, orders.getEmployee_id());
			preparedStatement.setString(5, orders.getDescriptionOfTheProblem());
			preparedStatement.setString(6, orders.getDescriptionRepair());
			preparedStatement.setInt(7, orders.getStatus_id());
			preparedStatement.setInt(8, orders.getVehicle_id());
			preparedStatement.setBigDecimal(9, orders.getRepairCost());
			preparedStatement.setBigDecimal(10, orders.getPartsCost());
			preparedStatement.setBigDecimal(11, orders.getCostOfManHour());
			preparedStatement.setInt(12, orders.getQuantityOfManHour());
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				orders.setId(rs.getInt(1));
			}
		} else {
			String sql = "UPDATE orders SET dateOfAcceptRepair=?, plannedStartDateOfTheRepair=?, dateOfRepairStarted=?, employee_id=?, descriptionOfTheProblem=?, descriptionRepair=?, status_id=?, vehicle_id=?, repairCost=?, partsCost=?, costOfManHour=?, quantityOfManHour=? where id=?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setDate(1, orders.getDateOfAcceptRepair());
			preparedStatement.setDate(2, orders.getPlannedStartDateOfTheRepair());
			preparedStatement.setDate(3, orders.getDateOfRepairStarted());
			preparedStatement.setInt(4, orders.getEmployee_id());
			preparedStatement.setString(5, orders.getDescriptionOfTheProblem());
			preparedStatement.setString(6, orders.getDescriptionRepair());
			preparedStatement.setInt(7, orders.getStatus_id());
			preparedStatement.setInt(8, orders.getVehicle_id());
			preparedStatement.setBigDecimal(9, orders.getRepairCost());
			preparedStatement.setBigDecimal(10, orders.getPartsCost());
			preparedStatement.setBigDecimal(11, orders.getCostOfManHour());
			preparedStatement.setInt(12, orders.getQuantityOfManHour());
			preparedStatement.setInt(13, orders.getId());
			preparedStatement.executeUpdate();
		}
	}

	static public Orders loadOrdersById(Connection conn, int id) throws SQLException {
		String sql = "SELECT * FROM orders where id=?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Orders loadedOrders = new Orders();
			loadedOrders.setId(resultSet.getInt("id"));
			loadedOrders.setDateOfAcceptRepair(resultSet.getDate("dateOfAcceptRepair"));
			loadedOrders.setPlannedStartDateOfTheRepair(resultSet.getDate("plannedStartDateOfTheRepair"));
			loadedOrders.setDateOfRepairStarted(resultSet.getDate("dateOfRepairStarted"));
			loadedOrders.setEmployee_id(resultSet.getInt("employee_id"));
			loadedOrders.setDescriptionOfTheProblem(resultSet.getString("descriptionOfTheProblem"));
			loadedOrders.setDescriptionRepair(resultSet.getString("descriptionRepair"));
			loadedOrders.setStatus_id(resultSet.getInt("status_id"));
			loadedOrders.setVehicle_id(resultSet.getInt("vehicle_id"));
			loadedOrders.setRepairCost(resultSet.getBigDecimal("repairCost"));
			loadedOrders.setPartsCost(resultSet.getBigDecimal("partsCost"));
			loadedOrders.setCostOfManHour(resultSet.getBigDecimal("costOfManHour"));
			loadedOrders.setQuantityOfManHour(resultSet.getInt("quantityOfManHour"));
			return loadedOrders;
		}
		return null;
	}

	static public Orders[] loadAllOrders(Connection conn) throws SQLException {
		ArrayList<Orders> listOrders = new ArrayList<Orders>();
		String sql = "SELECT * FROM	orders";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Orders loadedOrders = new Orders();
			loadedOrders.setId(resultSet.getInt("id"));
			loadedOrders.setDateOfAcceptRepair(resultSet.getDate("dateOfAcceptRepair"));
			loadedOrders.setPlannedStartDateOfTheRepair(resultSet.getDate("plannedStartDateOfTheRepair"));
			loadedOrders.setDateOfRepairStarted(resultSet.getDate("dateOfRepairStarted"));
			loadedOrders.setEmployee_id(resultSet.getInt("employee_id"));
			loadedOrders.setDescriptionOfTheProblem(resultSet.getString("descriptionOfTheProblem"));
			loadedOrders.setDescriptionRepair(resultSet.getString("descriptionRepair"));
			loadedOrders.setStatus_id(resultSet.getInt("status_id"));
			loadedOrders.setVehicle_id(resultSet.getInt("vehicle_id"));
			loadedOrders.setRepairCost(resultSet.getBigDecimal("repairCost"));
			loadedOrders.setPartsCost(resultSet.getBigDecimal("partsCost"));
			loadedOrders.setCostOfManHour(resultSet.getBigDecimal("costOfManHour"));
			loadedOrders.setQuantityOfManHour(resultSet.getInt("quantityOfManHour"));
			listOrders.add(loadedOrders);
		}
		Orders[] uArray = new Orders[listOrders.size()];
		uArray = listOrders.toArray(uArray);
		return uArray;
	}

	public void delete(Connection conn, int id) throws SQLException {
		if (id != 0) {
			String sql = "DELETE FROM orders WHERE id= ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			id = 0;
		}
	}
}
