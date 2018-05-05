package pl.coderslab.crm.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.crm.util.DbUtil;

/**
 * Servlet implementation class CreateTables
 */
@WebServlet("/createTables")
public class CreateTables extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateTables() {
		super();
	}

	private static final String QUERY1 = "CREATE TABLE employee(id int(11) AUTO_INCREMENT,\n"
			+ "                      name varchar(255),\n" + "                      surname varchar(255),\n"
			+ "                      address text,\n" + "                      phoneNumber varchar(255),\n"
			+ "                      note text,\n" + "                      costOfManHour decimal(8,2),\n"
			+ "                      PRIMARY KEY(id));";
	private static final String QUERY2 = "CREATE TABLE customer(id int(11) AUTO_INCREMENT,\n"
			+ "                      name varchar(255),\n" + "                      surname varchar(255),\n"
			+ "                      dateOfBirth date,\n" + "                      PRIMARY KEY(id));";
	private static final String QUERY3 = "CREATE TABLE vehicle(id int(11) AUTO_INCREMENT,\n"
			+ "                      model varchar(255),\n" + "                      mark varchar(255),\n"
			+ "                      yearOfProduction year,\n"
			+ "                      registrationNumber varchar(255),\n"
			+ "                      dateOfTheNextTechnicalInspection date,\n"
			+ "                      customer_id int(11),\n" + "                      PRIMARY KEY(id),\n"
			+ "                      FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE CASCADE);";
	private static final String QUERY4 = "CREATE TABLE orderStatus(id int(11) AUTO_INCREMENT,\n"
			+ "                    order_status varchar(255),\n" + "                    PRIMARY KEY(id));";
	private static final String QUERY5 = "CREATE TABLE orders(id int(11) AUTO_INCREMENT,\n"
			+ "                    dateOfAcceptRepair date,\n"
			+ "                    plannedStartDateOfTheRepair date,\n"
			+ "                    dateOfRepairStarted date,\n" + "                    employee_id int(11),\n"
			+ "                    descriptionOfTheProblem text,\n" + "                    descriptionRepair text,\n"
			+ "                    status_id int(11),\n" + "                    vehicle_id int(11),\n"
			+ "                    repairCost decimal(10,2),\n" + "                    partsCost decimal(10,2),\n"
			+ "                    costOfManHour decimal(8,2),\n"
			+ "                    quantityOfManHour bigint(20),\n" + "                    PRIMARY KEY(id),\n"
			+ "                    FOREIGN KEY(employee_id) REFERENCES employee(id) ON DELETE CASCADE,\n"
			+ "                    FOREIGN KEY(vehicle_id) REFERENCES vehicle(id) ON DELETE CASCADE,\n"
			+ "                    FOREIGN KEY(status_id) REFERENCES orderStatus(id) ON DELETE CASCADE);";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection c = DbUtil.getConn();
			Statement stm = c.createStatement();
			stm.executeUpdate(QUERY1);
			stm.executeUpdate(QUERY2);
			stm.executeUpdate(QUERY3);
			stm.executeUpdate(QUERY4);
			stm.executeUpdate(QUERY5);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
